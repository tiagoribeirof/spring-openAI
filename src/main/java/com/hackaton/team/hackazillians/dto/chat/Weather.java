package com.hackaton.team.hackazillians.dto.chat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.hackaton.team.hackazillians.constant.WeatherUnit;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Weather {
    @JsonPropertyDescription("City and state, for example: León, Guanajuato")
    public String location;

    @JsonPropertyDescription("The temperature unit, can be 'celsius' or 'fahrenheit'")
    @JsonProperty(required = true)
    public WeatherUnit unit;
}
