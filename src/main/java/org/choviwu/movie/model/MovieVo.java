package org.choviwu.movie.model;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choviwu.movie.annotation.ReturnNull;
import org.choviwu.movie.config.returnhandler.NullToEmpty;
import org.choviwu.movie.config.returnhandler.WxUserReturnSelector;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieVo {

    @NullToEmpty(isObj = true)
    private UserInputVo userInputVo;
}