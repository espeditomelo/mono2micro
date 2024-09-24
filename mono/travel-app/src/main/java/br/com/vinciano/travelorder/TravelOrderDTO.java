package br.com.vinciano.travelorder;

import br.com.vinciano.flight.Flight;
import br.com.vinciano.hotel.Hotel;

public class TravelOrderDTO {
    
    private String fromAirport;
    private String toAirport;
    private Integer nights;

    public TravelOrderDTO(){
        
    }

    // construtor privato pra trabalhar com um builder
    private TravelOrderDTO(String fromAirport, String toAirport, Integer nights){
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.nights = nights;
    }

    // para quando for listar todas as order esse builder facilitará para pegar os dados
    public static TravelOrderDTO of(TravelOrder travelOrder, Flight flight, Hotel hotel){
        return new TravelOrderDTO(flight.fromAirport, flight.toAirport, hotel.nights);
    }

    public static TravelOrderDTO of(String fromAirport, String toAirport, Integer nights){
        return new TravelOrderDTO(fromAirport, toAirport, nights);
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Integer getNights() {
        return nights;
    }

    public void setNights(Integer nights) {
        this.nights = nights;
    }

    

}
