package org.choviwu.movie.service.handler;

import lombok.extern.slf4j.Slf4j;
import org.choviwu.movie.mapper.UserInputMapper;
import org.choviwu.movie.model.Abstract.MessageInter;
import org.choviwu.movie.model.Abstract.Model;
import org.choviwu.movie.model.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserInputHandler {


    private final UserInputMapper inputMapper;

    @Autowired
    UserInputHandler(UserInputMapper inputMapper){
        this.inputMapper = inputMapper;
    }

    public void deal(MessageInter inter){
        Model model = (Model)inter;
        UserInput userInput = model.getInput();
        log.info("UserInput : "+ userInput.getOpenid() +
                "  Content : "+ userInput.getContent()+"  Remark : "+ userInput.getRemark());
        inputMapper.insertSelective(userInput);
    }

}
