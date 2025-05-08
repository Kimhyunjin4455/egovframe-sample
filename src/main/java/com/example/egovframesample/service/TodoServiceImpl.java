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
    public TodoVo getTodo(Long id) {
        TodoVo todo = todoMapper.findById(id);
        if (todo == null) {
            throw new IllegalArgumentException("해당 Todo 항목이 존재하지 않습니다. id = " + id);
        }
        return todo;
    }

    @Override
    public void addToDo(TodoVo todoVo) {
        todoMapper.saveTodo(todoVo);
    }

    @Override
    public void modifyToDo(Long id, String title, String description) {
        TodoVo existing = todoMapper.findById(id);
        if (existing == null) {
            throw new RuntimeException("Todo 항목이 존재하지 않습니다.");
        }

        // 빈 값이 아닌 경우에만 덮어쓰기
        if (title != null && !title.isBlank()) {
            existing.setTitle(title);
        }
        if (description != null && !description.isBlank()) {
            existing.setDescription(description);
        }
        todoMapper.updateToDoById(id, existing.getTitle(), existing.getDescription());
    }

    @Override
    public void deleteToDo(Long id) {
        int result = todoMapper.deleteById(id);
        if(result == 0){
//            log.error("입력값이 올바르지 않습니다.");
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }else {
            log.info("삭제 성공: info = " + id);
            // Q. 코드는 github에 공개될 것, 이러면 퀴리 인젝션 방지 위해 id라는 표현을 info로 처리하는것이 의미 있나?
            // Q. real 프로파일 시 error도 봐야하지만 유저의 플로우도 봐야 하지 않나..?
            // 유저의 행동과 관련된 부분의 로그레벨은 의문
        }



    }
}
