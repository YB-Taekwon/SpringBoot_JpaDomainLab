package com.ian.weatherdiary.controller;

import com.ian.weatherdiary.dto.request.DiaryCreateRequest;
import com.ian.weatherdiary.dto.request.DiaryReadRequest;
import com.ian.weatherdiary.service.DiaryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/list")
    public ResponseEntity<?> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
        return ResponseEntity.ok().body(diaryService.readDiaries(date));
    }

    @PostMapping("/list")
    public ResponseEntity<?> readDiaries(@Valid @RequestBody DiaryReadRequest request) {
        return ResponseEntity.ok().body(diaryService.readDiaries(request));
    }

    @GetMapping("/{diaryId}")
    public ResponseEntity<?> readDiary(@PathVariable Long diaryId) {
        return ResponseEntity.ok().body(diaryService.readDiary(diaryId));
    }
}
