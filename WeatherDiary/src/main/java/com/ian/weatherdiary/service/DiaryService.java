package com.ian.weatherdiary.service;

import com.ian.weatherdiary.domain.Diary;
import com.ian.weatherdiary.dto.request.DiaryCreateRequest;
import com.ian.weatherdiary.dto.request.DiaryReadRequest;
import com.ian.weatherdiary.dto.response.DiaryReadResponse;
import com.ian.weatherdiary.dto.response.WeatherResponse;
import com.ian.weatherdiary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<DiaryReadResponse> readDiaries(LocalDate date) {
        List<Diary> diaries = diaryRepository.findAllByDate(date);

        return diaries.stream().map(DiaryReadResponse::from).toList();
    }

    public List<DiaryReadResponse> readDiaries(DiaryReadRequest request) {
        List<Diary> diaries = diaryRepository.findAllByDateBetween(request.getStartDate(), request.getEndDate());

        return diaries.stream().map(DiaryReadResponse::from).toList();
    }

    public DiaryReadResponse readDiary(Long diaryId) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new IllegalArgumentException("Diary not found"));

        return DiaryReadResponse.from(diary);
    }
}
