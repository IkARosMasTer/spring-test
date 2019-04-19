package org.choviwu.movie.config.returnhandler;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
@Component
public class ReturnSelectorChain {

    private List<ReturnSelector> returnSelectors;

    public ReturnSelectorChain(ReturnSelector... returnSelector){
        returnSelectors.addAll(Arrays.asList(returnSelector));
    }
    public ReturnSelectorChain( ){
    }

    public void setReturnSelectors(List<ReturnSelector> returnSelectors) {
        this.returnSelectors = returnSelectors;
    }

    public List<ReturnSelector> getReturnSelectors() {
        return returnSelectors;
    }


    public void match(Object obj, Object result, Field field, String str){
        for (int i = 0;i<returnSelectors.size();i++){
            ReturnSelector returnSelector = returnSelectors.get(i);
            if(returnSelector.supportsFieldType(field.getType(),field)){

                returnSelector.match(obj,result,field,str);
                break;
            }
        }
    }
}
