package org.choviwu.movie.model;


import org.choviwu.movie.base.BaseModel;

import java.io.Serializable;

public class EventMessage extends BaseModel implements Serializable {

    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
