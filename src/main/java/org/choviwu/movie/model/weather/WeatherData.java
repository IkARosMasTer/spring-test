package org.choviwu.movie.model.weather;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@EqualsAndHashCode
public class WeatherData implements Serializable {
    private String province;
    private String city;
    private String w3;
    private String img;
    private String alarm;
    private String bg;
    private String color;
    private String update;
    private String info;
    private String w10;
    private String w11;
    private String w13;
    private String w12;

}
