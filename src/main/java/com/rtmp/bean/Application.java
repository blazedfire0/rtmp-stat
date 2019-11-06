package com.rtmp.bean;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 12:51
 * @描述 TODO
 */
@Getter
public class Application extends SuperValue{
    private String name;//房间名称

    private List<LiveStreams> liveStreams;

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "name":name = ((String) value);break;
            default:break;
        }
    }

    public void setLiveStreams(LiveStreams stream) {
        if (liveStreams == null){
            liveStreams = new ArrayList<>();
        }
        liveStreams.add(stream);
    }
}
