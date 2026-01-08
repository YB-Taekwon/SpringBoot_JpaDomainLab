package com.ian.weatherdiary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpenWeatherMapResponse {

    private List<Weather> weather;
    private Main main;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Weather {

        private String main;
        private String icon;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Main {
        private Double temp;
    }
}
