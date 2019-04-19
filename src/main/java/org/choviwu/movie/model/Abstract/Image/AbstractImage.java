package org.choviwu.movie.model.Abstract.Image;

import org.choviwu.movie.model.Image;
import org.choviwu.movie.model.ImageMessage;

public abstract class AbstractImage {

    ImageMessage imageMessage;

    public AbstractImage() {
        imageMessage = new ImageMessage();
    }

    public  abstract ImageMessage deal(String mediaId, Image image, String tuUserName, String fromUserName);
}
