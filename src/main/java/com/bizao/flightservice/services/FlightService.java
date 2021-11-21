package com.bizao.flightservice.services;


import java.util.Collection;
import com.bizao.flightservice.models.Flight;


public interface FlightService {
    Collection<Flight> getFlightPricesHistory(String origin, String destination);
    Collection<Flight> getFlightCalendarOfPricesForMonth(String origin, String destination, String month);
    Collection<Flight> getFlightPricesForAlternativeDirection(String origin, String destination, String depart_date);

}
