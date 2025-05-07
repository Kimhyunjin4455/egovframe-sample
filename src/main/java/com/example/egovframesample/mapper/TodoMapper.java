package com.example.egovframesample.mapper;

import com.example.egovframesample.vo.TodoVo;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;


@Mapper
public interface TodoMapper {
    List<TodoVo> findAll();
    TodoVo findById(Long id);
    void saveTodo(TodoVo todoVo);
    void updateToDoById(Long id, String title, String description);
//    void updateTitleById(Long id);
//    void updateDescriptionById(Long id);
    int deleteById(Long id);

}
