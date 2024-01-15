package com.apipractice.mapper;

import com.apipractice.dto.ListDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface ListMapper {
    @Insert("insert into `list` values (null, #{title}, #{address},#{language})")
    void db_insert(ListDTO listDTO);


}
