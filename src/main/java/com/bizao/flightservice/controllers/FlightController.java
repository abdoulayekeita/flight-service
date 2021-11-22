package com.bizao.flightservice.controllers;

import com.bizao.flightservice.models.Flight;
import com.bizao.flightservice.models.Response;
import com.bizao.flightservice.services.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "Flight Rest Endpoint",description = "Travel insights with Travelpayouts Data API")
public class FlightController {
    private final FlightService flightService;

    @ApiOperation(value = "Returns flights collection", notes = "Brings back the list of prices found by our users during the most recent 48 hours according to the filters used", response = Flight.class)
    @GetMapping("/flight_prices_history/{origin}/{destination}")
    public ResponseEntity<Response> getFlightPricesHistory(@PathVariable("origin") String origin, @PathVariable("destination") String destination){
        return ResponseEntity
                .ok(
                        Response.builder()
                                .timeStamp(now())
                                .data(of("flights", flightService.getFlightPricesHistory(origin,destination)))
                                .message("Flight prices history retrieved")
                                .status(OK)
                                .statusCode(OK.value())
                                .build()
                );
    }

    @ApiOperation(value = "Returns flights collection", notes = "Brings back the prices for each day of a month, grouped together by number of transfers.", response = Flight.class)
    @GetMapping("/flight_calendar_prices_month/{origin}/{destination}/{month}")
    public ResponseEntity<Response> getFlightCalendarOfPricesForMonth(@PathVariable("origin") String origin, @PathVariable("destination") String destination, @PathVariable("month") String month){
        return ResponseEntity
                .ok(
                        Response.builder()
                                .timeStamp(now())
                                .data(of("flights", flightService.getFlightCalendarOfPricesForMonth(origin,destination,month)))
                                .message("Flight calendar of prices for month retrieved")
                                .status(OK)
                                .statusCode(OK.value())
                                .build()
                );
    }

    @ApiOperation(value = "Returns flight collection", notes = "Brings back the prices for the directions between the nearest to the target cities.", response = Flight.class)
    @GetMapping("/flight_prices_alternative_direction/{origin}/{destination}/{depart_date}")
    public ResponseEntity<Response> getFlightPricesForAlternativeDirection(@PathVariable("origin") String origin, @PathVariable("destination") String destination, @PathVariable("depart_date") String depart_date){
        return ResponseEntity
                .ok(
                        Response.builder()
                                .timeStamp(now())
                                .data(of("flights", flightService.getFlightPricesForAlternativeDirection(origin, destination, depart_date)))
                                .message("Flight prices for alternative direction retrieved")
                                .status(OK)
                                .statusCode(OK.value())
                                .build()
                );
    }
}
