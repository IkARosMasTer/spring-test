package org.choviwu.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.choviwu.movie.model.UserInput;
import org.choviwu.movie.model.UserInputExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface UserInputMapper extends Mapper<UserInput>{

    int count();

    int insertLog(@Param("content") String content, @Param("response") String response, @Param("remark") String remark,
                  @Param("openid") String openid);
    UserInput getLastInputByOpenId(Map map);
}