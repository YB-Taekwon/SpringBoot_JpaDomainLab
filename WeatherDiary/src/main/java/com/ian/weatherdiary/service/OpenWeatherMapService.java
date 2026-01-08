package com.ian.weatherdiary.service;

import com.ian.weatherdiary.dto.response.OpenWeatherMapResponse;
import com.ian.weatherdiary.dto.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class OpenWeatherMapService {

    private final RestTemplate restTemplate;

    @Value("${open-weather-map.base-url}")
    private String baseUrl;

    @Value("${open-weather-map.default-city}")
    private String defaultCity;

    @Value("${open-weather-map.api-key}")
    private String apiKey;

    public WeatherResponse parseWeather() {
        OpenWeatherMapResponse response = fetchWeather();

        return WeatherResponse.builder()
                .weather(response.getWeather().getFirst().getMain())
                .temp(response.getMain().getTemp())
                .icon(response.getWeather().getFirst().getIcon())
                .build();
    }

    private OpenWeatherMapResponse fetchWeather() {

        String url = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("q", defaultCity)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build()
                .toUriString();

        return restTemplate.getForObject(url, OpenWeatherMapResponse.class);
    }
}
