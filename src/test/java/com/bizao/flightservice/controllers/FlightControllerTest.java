package com.bizao.flightservice.controllers;

import com.bizao.flightservice.models.Flight;
import com.bizao.flightservice.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;


@WebMvcTest(value = FlightController.class)
class FlightControllerTest {
    @Autowired
    private MockMvc  mockMvc;
    @MockBean
    private FlightService flightService;

    Collection<Flight> flight = Arrays.asList(
            new Flight(),
            new Flight()
    );

    @Test
    void getFlightPricesHistory() throws Exception {
        Mockito.when(flightService.getFlightPricesHistory(Mockito.anyString(), Mockito.anyString())).thenReturn(flight);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/flight_prices_history/FR/ML").accept(APPLICATION_JSON);

        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        assertThat(mvcResult.getResponse()).isNotNull();
    }

    @Test
    void getFlightCalendarOfPricesForMonth() throws Exception {
        Mockito.when(flightService.getFlightCalendarOfPricesForMonth(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(flight);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/flight_calendar_prices_month/FR/ML/2021-12-01").accept(APPLICATION_JSON);

        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        assertThat(mvcResult.getResponse()).isNotNull();
    }

    @Test
    void getFlightPricesForAlternativeDirection() throws Exception {
        Mockito.when(flightService.getFlightPricesForAlternativeDirection(Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(flight);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/flight_prices_alternative_direction/FR/ML/2021-12-01").accept(APPLICATION_JSON);

        MvcResult mvcResult= mockMvc.perform(requestBuilder).andReturn();
        assertThat(mvcResult.getResponse()).isNotNull();
    }
}