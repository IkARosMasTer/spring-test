package org.choviwu.movie.model.Abstract.Image;


import org.choviwu.movie.model.Image;
import org.choviwu.movie.model.ImageMessage;
import org.choviwu.movie.util.WechatMessageUtil;

import java.io.Serializable;
import java.util.Date;

public  class ImageDeal extends AbstractImage implements Serializable {


    public ImageMessage deal(String mediaId, Image image, String toUserName, String fromUserName) {
       image.setMediaId(mediaId);
       imageMessage.setImage(image);
       imageMessage.setMsgType(WechatMessageUtil.MESSAtGE_IMAGE);
       setBaseProperty(toUserName,fromUserName);
        return imageMessage;
    }

    public void setBaseProperty(String toUserName,String fromUserName){
        imageMessage.setToUserName(fromUserName);
        imageMessage.setFromUserName(toUserName);
        imageMessage.setCreateTime(new Date().getTime());
    }
}
