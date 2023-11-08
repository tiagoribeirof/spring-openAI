package com.hackaton.team.hackazillians.dto.chat;

import com.hackaton.team.hackazillians.constant.WeatherUnit;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherResponse {

    public String location;
    public WeatherUnit unit;
    public int temperature;
    public String description;
}
