package com.bizao.flightservice.services;


import com.bizao.flightservice.models.Flight;
import com.bizao.flightservice.models.ResponseRapidApiTypeA;
import com.bizao.flightservice.models.ResponseRapidApiTypeB;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightServiceImplementation implements FlightService{
    private final RestTemplate restTemplate;
    @Value("${rapidapi.flight.data.token}")
    private  String api_token;
    @Value("${rapidapi.flight.price.history.data.url}")
    private  String rapidapiFlightPriceHistoryDataUrl;
    @Value("${rapidapi.flight.calendar.of.prices.for.month.data.url}")
    private  String rapidapiFlightCalendarOfPricesForMonthDataUrl;
    @Value("${rapidapi.flight.prices.for.alternative.directions.data.url}")
    private  String rapidapiFlightPricesForAlternativeDirectionsDataUrl;

    @Override
    public Collection<Flight> getFlightPricesHistory(String origin, String destination) {
        log.info("Fetching flight prices history data from rapiApi.");
        ResponseRapidApiTypeA responseRapidApiTypeA = restTemplate.getForObject(rapidapiFlightPriceHistoryDataUrl+"?token="+api_token+"&origin="+origin+"&destination="+destination, ResponseRapidApiTypeA.class);
        return Arrays.stream(responseRapidApiTypeA.getData()).collect(Collectors.toList());
    }

    @Override
    public Collection<Flight> getFlightCalendarOfPricesForMonth(String origin, String destination, String month) {
        log.info("Fetching flight calendar of prices for a month data from rapiApi.");
        ResponseRapidApiTypeA responseRapidApiTypeA = restTemplate.getForObject(rapidapiFlightCalendarOfPricesForMonthDataUrl+"?token="+api_token+"&origin="+origin+"&destination="+destination+"&month="+month, ResponseRapidApiTypeA.class);
        return Arrays.stream(responseRapidApiTypeA.getData()).collect(Collectors.toList());
    }

    @Override
    public Collection<Flight> getFlightPricesForAlternativeDirection(String origin, String destination, String depart_date) {
        log.info("Fetching flight prices for the alternative directions data from rapiApi.");
        ResponseRapidApiTypeB responseRapidApiTypeB = restTemplate.getForObject(rapidapiFlightPricesForAlternativeDirectionsDataUrl+"?token="+api_token+"&origin="+origin+"&destination="+destination+"&depart_date="+depart_date, ResponseRapidApiTypeB.class);
        return Arrays.stream(responseRapidApiTypeB.getPrices()).collect(Collectors.toList());    }
}
