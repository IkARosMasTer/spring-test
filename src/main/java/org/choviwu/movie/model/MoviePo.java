package org.choviwu.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class MoviePo implements Serializable {

    private String toUserName;
    private String fromUserName;
    private List<Item> items;

    public MoviePo(String toUserName, String fromUserName, List<Item> items) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.items = items;
    }
}
