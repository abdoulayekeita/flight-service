package com.bizao.flightservice.models;

import lombok.Data;

@Data
public class ResponseRapidApiTypeA {
    private String success;
    private Flight[] data;
    private String currency;
    private String error;
}
