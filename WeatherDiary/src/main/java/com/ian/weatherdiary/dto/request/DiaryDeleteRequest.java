package com.ian.weatherdiary.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Getter
@NoArgsConstructor
public class DiaryDeleteRequest {

    private Collection<Long> diaryIds;
}
