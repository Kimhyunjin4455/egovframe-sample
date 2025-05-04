package com.example.egovframesample.mapper;

import com.example.egovframesample.vo.TodoVo;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import java.util.List;


@Mapper
public interface TodoMapper {
    List<TodoVo> findAll();
    void insert(TodoVo todoVo);
}
