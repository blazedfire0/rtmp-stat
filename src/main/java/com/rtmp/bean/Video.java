package com.rtmp.bean;

import lombok.Getter;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 14:27
 * @描述 TODO
 */
@Getter
public class Video extends SuperValue{

    private String width;
    private String height;
    private String frameRate;
    private String codec;
    private String profile;
    private String compat;
    private String level;

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "width":width = ((String) value);break;
            case "height":height = ((String) value);break;
            case "frame_rate":frameRate = ((String) value);break;
            case "codec":codec = ((String) value);break;
            case "profile":profile = ((String) value);break;
            case "compat":compat = ((String) value);break;
            case "level":level = ((String) value);break;
            default:break;
        }
    }
}
