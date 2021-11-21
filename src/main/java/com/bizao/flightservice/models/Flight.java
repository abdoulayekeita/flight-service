package com.bizao.flightservice.models;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Flight {
    @ApiModelProperty(notes = "the cost of a flight, in the currency specified")
    private String value;
    @ApiModelProperty(notes = "the flight class")
    private String trip_class;
    @ApiModelProperty(notes = "false - all the prices, true - just the prices, found using the partner marker (recommended). The default value - true")
    private String show_to_affiliates;
    @ApiModelProperty(notes = "the point of departure")
    private String origin;
    @ApiModelProperty(notes = "the point of destination")
    private String destination;
    @ApiModelProperty(notes = "the agents, which was found on the ticket")
    private String gate;
    @ApiModelProperty(notes = "the date of departure")
    private String depart_date;
    @ApiModelProperty(notes = " the date of return")
    private String return_date;
    @ApiModelProperty(notes = "the number of transfers")
    private String number_of_changes;
    @ApiModelProperty(notes = "the time and the date at/on which a ticket was found")
    private String found_at;
    @ApiModelProperty(notes = "the flight duration in minutes, taking into account direct and expectations.")
    private String duration;
    @ApiModelProperty(notes = " the distance between the point of departure and the point of destination")
    private String distance;
    @ApiModelProperty(notes = " the actuality of an offer")
    private String actual;
}
