CREATE SEQUENCE travelorder_sequence START WITH 1 INCREMENT BY 1;
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
-- INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

CREATE SEQUENCE flight_sequence START WITH 1 INCREMENT BY 1;
-- INSERT INTO Flight(id, travelorderid, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'GRU', 'MCO');
-- INSERT INTO Flight(id, travelorderid, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'GRU', 'REC');
-- INSERT INTO Flight(id, travelorderid, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'REC', 'GRU');
-- INSERT INTO Flight(id, travelorderid, fromAirport, toAirport) VALUES (nextval('flight_sequence'), 1, 'GRU', 'CON');

CREATE SEQUENCE hotel_sequence START WITH 1 INCREMENT BY 1;
-- INSERT INTO Hotel(id, travelorderid, nights) VALUES (nextval('hotel_sequence'), 1, 3);
-- INSERT INTO Hotel(id, travelorderid, nights) VALUES (nextval('hotel_sequence'), 2, 5);
-- INSERT INTO Hotel(id, travelorderid, nights) VALUES (nextval('hotel_sequence'), 3, 8);
-- INSERT INTO Hotel(id, travelorderid, nights) VALUES (nextval('hotel_sequence'), 4, 10);
-- INSERT INTO Hotel(id, travelorderid, nights) VALUES (nextval('hotel_sequence'), 5, 15);