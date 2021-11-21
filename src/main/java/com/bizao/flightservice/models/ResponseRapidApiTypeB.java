package com.bizao.flightservice.models;

import lombok.Data;

@Data
public class ResponseRapidApiTypeB {
    private Flight[] prices;
    private String[] origins;
    private String errors;
    private String[] destinations;
}
