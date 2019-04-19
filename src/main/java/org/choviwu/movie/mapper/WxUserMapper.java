package org.choviwu.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.choviwu.movie.model.WxUser;
import org.choviwu.movie.model.WxUserExample;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WxUserMapper extends Mapper<WxUser>{

    WxUser selectByOpenId(String openId);
    int count();
    List<WxUser> getList();
}