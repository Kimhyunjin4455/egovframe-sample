package com.example.egovframesample.service;

import com.example.egovframesample.vo.TodoVo;

import java.util.List;

public interface TodoService {
    List<TodoVo> getTodoList();
    void addToDo(TodoVo todoVo);
}
