package com.example.egovframesample.dto.in;

import com.example.egovframesample.vo.TodoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    private String title;
    private String description;

    public TodoVo dtoToVo(){
        return TodoVo.builder()
                .title(title)
                .description(description)
                .build();
    }

    @Builder
    public TodoRequestDto(String title, String description){
        this.title = title;
        this.description = description;
    }

}
