package com.example.egovframesample.service;

import com.example.egovframesample.vo.TodoVo;

import java.util.List;

public interface TodoService {
    List<TodoVo> getTodoList();
    TodoVo getTodo(Long id);
    void addToDo(TodoVo todoVo);
    void modifyToDo(Long id, String title, String description);
    void deleteToDo(Long id);
}
