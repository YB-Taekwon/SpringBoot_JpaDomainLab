package com.ian.weatherdiary.service;

import com.ian.weatherdiary.domain.Diary;
import com.ian.weatherdiary.dto.request.DiaryCreateRequest;
import com.ian.weatherdiary.dto.response.WeatherResponse;
import com.ian.weatherdiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final OpenWeatherMapService openWeatherMapService;

    public void create(DiaryCreateRequest request) {

        WeatherResponse weather = openWeatherMapService.parseWeather();

        diaryRepository.save(Diary.builder()
                .weather(weather.getWeather())
                .temp(weather.getTemp())
                .icon(weather.getIcon())
                .date(request.getDate())
                .content(request.getContent())
                .build()
        );
    }
}
