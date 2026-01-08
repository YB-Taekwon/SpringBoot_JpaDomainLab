package com.ian.weatherdiary.dto.response;

import com.ian.weatherdiary.domain.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryReadResponse {

    private Long id;
    private LocalDate date;
    private String weather;
    private Double temp;
    private String icon;
    private String content;

    public static DiaryReadResponse from(Diary diary) {
        return DiaryReadResponse.builder()
                .id(diary.getId())
                .date(diary.getDate())
                .weather(diary.getWeather())
                .temp(diary.getTemp())
                .icon(diary.getIcon())
                .content(diary.getContent())
                .build();
    }
}
