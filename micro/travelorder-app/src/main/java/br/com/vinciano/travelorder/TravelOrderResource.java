package br.com.vinciano.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("travelorder")
public class TravelOrderResource {

    @Inject 
    @RestClient
    FlightService flightService;

    @Inject
    @RestClient
    HotelService hotelService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public List<TravelOrderDTO> orders(){
        System.out.println(Thread.currentThread());
        return TravelOrder.<TravelOrder>listAll().stream()
            .map(
                order -> TravelOrderDTO.of(
                    order, 
                    flightService.findByTravelOrderId(order.id),
                    hotelService.findByTravelOrderId(order.id)
            )
            ).collect(Collectors.toList());
    }
    
    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder findById(@QueryParam("id") Long id){
        return TravelOrder.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO orderDTO){
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.setFromAirport(orderDTO.getFromAirport());
        flight.setToAirport(orderDTO.getToAirport());
        flight.setTravelOrderId(order.id);
        flightService.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.setNights(orderDTO.getNights());
        hotel.setTravelOrderId(order.id);
        hotelService.newHotel(hotel);

        return order;
    }


}
