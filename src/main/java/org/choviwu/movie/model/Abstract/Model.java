package org.choviwu.movie.model.Abstract;



import org.choviwu.movie.model.UserInput;

import java.io.Serializable;

public abstract class Model implements MessageInter,Serializable {

    protected UserInput input;

    Model(){input = new UserInput();}

    public UserInput getInput() {
        return input;
    }

    public abstract void deal(String fromUserName, String content,String response);


}
