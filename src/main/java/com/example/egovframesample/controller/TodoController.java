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

    @GetMapping("/myDo")
    @Operation(summary = "todo 1 item get api", description = "원하는 할 일 하나 조회")
    public TodoResponseDto getTodo(@RequestParam Long id){
        TodoVo todoVo = todoService.getTodo(id);
        log.info(todoVo.getTitle() +": "+ todoVo.getDescription());
        return new TodoResponseDto(todoVo);
    }

    @PostMapping("/addmemo")
    @Operation(summary = "todo list post api", description = "투두 항목 입력")
    public void addTodo(@RequestParam String title,
                        @RequestParam String description){
        TodoVo todoVo = new TodoVo();
        todoVo.setTitle(title);
        todoVo.setDescription(description);
        todoVo.setIs_done(false); // default value
        todoService.addToDo(todoVo);
        log.info("Todo added successfully: " + todoVo.getTitle());
//        return "add finish";
    }

    @PutMapping("/update-content")
    @Operation(summary = "todo content update api", description = "투두 항목 수정")
    public void modifyToDo(@RequestParam Long id,
                           @RequestParam(required = false) String title, // title은 not null 컬럼 But 부분 업데이트 위해 false 설정
                           @RequestParam(required = false) String description){
        todoService.modifyToDo(id, title, description);
        log.info("Todo modifyed successfully " + title +": "+description);

    }

    @DeleteMapping("/delete-content")
    @Operation(summary = "todo content delete api", description = "투두 항목 삭제")
    public void removeToDo(@RequestParam Long id){
        todoService.deleteToDo(id);
        log.info("Todo deleted successfully" + " id: " +id);

    }


}
