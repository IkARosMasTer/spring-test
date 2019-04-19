package org.choviwu.movie.model.weather;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
public class Weather implements Serializable {

    private String status;
    private String msg;
    private String city;
    private String weathercode;
    private String update;
    private List<WeatherData> data;


    public String toString(){

        return data.get(0).getInfo();
    }

}
