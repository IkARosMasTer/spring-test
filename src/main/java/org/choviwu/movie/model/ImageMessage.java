package org.choviwu.movie.model;


import org.choviwu.movie.base.BaseModel;

import java.io.Serializable;

public class ImageMessage extends BaseModel implements Serializable {

    private Image Image;

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }
}
