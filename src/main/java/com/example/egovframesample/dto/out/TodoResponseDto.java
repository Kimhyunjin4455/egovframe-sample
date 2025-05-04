package com.example.egovframesample.dto.out;

import com.example.egovframesample.vo.TodoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoResponseDto {
    private String title;
    private String description;

    // TodoVo를 응답 DTO로 변환
    public TodoResponseDto(TodoVo todoVo) {
        this.title = todoVo.getTitle();
        this.description = todoVo.getDescription();
    }

    @Builder
    public TodoResponseDto(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
