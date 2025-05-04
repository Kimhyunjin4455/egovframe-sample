package com.example.egovframesample.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoVo {
    private Long id;
    private String title;
    private String description;
    private Boolean is_done;
    private LocalDateTime createdAt;
}
