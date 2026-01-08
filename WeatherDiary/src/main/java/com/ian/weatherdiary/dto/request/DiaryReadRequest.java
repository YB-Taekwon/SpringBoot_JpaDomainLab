package com.ian.weatherdiary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class DiaryReadRequest {

    private LocalDate startDate;
    private LocalDate endDate;
}
