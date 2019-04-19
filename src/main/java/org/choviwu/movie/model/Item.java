package org.choviwu.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Item {

    private String Title;

    private String Description;

    private String PicUrl;

    private String Url;


    @Override
    public String toString() {
        return "Item{"+
                ", 电影名='" + Title + '\'' +
                ", 演员列表='" + Description + '\'' +
                ", Logo='" + PicUrl + '\'' +
                ", 原影链接='" + Url + '\'' +
                '}';
    }
}