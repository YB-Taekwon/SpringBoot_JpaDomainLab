package com.ian.weatherdiary.controller;

import com.ian.weatherdiary.dto.request.DiaryCreateRequest;
import com.ian.weatherdiary.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather-diary")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DiaryCreateRequest request) {
        diaryService.create(request);

        return ResponseEntity.ok().build();
    }
}
