package com.ian.weatherdiary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String weather;

    @Column(nullable = false)
    private Double temp;

    @Column(nullable = false)
    private String icon;

    @Column(nullable = false)
    private String content;

    public void updateContent(String content) {
        this.content = content;
    }
}
