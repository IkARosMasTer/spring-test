package org.choviwu.movie.mapper;

import org.apache.ibatis.annotations.Param;
import org.choviwu.movie.model.Config;
import org.choviwu.movie.model.ConfigExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ConfigMapper extends Mapper<Config>{

    String getDBValueByParam(String param);

    List<Config> getList();
}