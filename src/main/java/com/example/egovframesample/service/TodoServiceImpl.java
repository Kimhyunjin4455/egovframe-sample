package com.example.egovframesample.service;

import com.example.egovframesample.mapper.TodoMapper;
import com.example.egovframesample.vo.TodoVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.cmmn.trace.LeaveaTrace;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j
public class TodoServiceImpl extends EgovAbstractServiceImpl implements TodoService {

    private final TodoMapper todoMapper;
    private final LeaveaTrace leaveaTrace;

    @Override
    public List<TodoVo> getTodoList() {
        return todoMapper.findAll();
    }

    @Override
    public void addToDo(TodoVo todoVo) {
        todoMapper.insert(todoVo);
    }
}
