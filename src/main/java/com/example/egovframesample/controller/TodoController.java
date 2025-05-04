package com.example.egovframesample.controller;

import com.example.egovframesample.dto.out.TodoResponseDto;
import com.example.egovframesample.service.TodoService;
import com.example.egovframesample.vo.TodoVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Log4j
@Tag(name= "Todo List", description = "투두리스트 api")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/mylist")
    @Operation(summary = "todo list get api", description = "투두리스트 전체 조회")
    public List<TodoResponseDto> getTodos() {
        return todoService.getTodoList().stream()
                .peek(todoVo -> log.info("Processing Todo: " + todoVo))  // TodoVo 객체 로그 출력
                .map(TodoResponseDto::new) // // TodoVo -> TodoResponseDto
                .collect(Collectors.toList());
    }

    @PostMapping("/addmemo")
    @Operation(summary = "todo list post api", description = "투두 항목 입력")
    public String createTodo(@RequestBody TodoVo todoVo){
        todoService.addToDo(todoVo);
        log.info("Todo added successfully: " + todoVo);
        return "add finish";
    }
}
