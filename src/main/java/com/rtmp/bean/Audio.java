package com.rtmp.bean;

import lombok.Getter;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 14:29
 * @描述 TODO
 */
@Getter
public class Audio extends SuperValue{

    private String codec;
    private String profile;
    private String channels;
    private String sampleRate;
    private String nclients;
    private String type;
    private String active;

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "codec":codec = ((String) value);break;
            case "profile":profile = ((String) value);break;
            case "channels":channels = ((String) value);break;
            case "sample_rate":sampleRate = ((String) value);break;
            case "nclients":nclients = ((String) value);break;
            case "publishing":type = tagName;break;
            case "active":active = tagName;break;
            default:break;
        }
    }
}
