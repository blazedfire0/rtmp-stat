package com.rtmp.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 12:57
 * @描述 TODO
 */
@Getter
public class LiveStreams extends SuperValue{
    private String name;//live名称
    private int time;//运行时间
    private int bwIn;
    private int bytesIn;
    private int bwOut;
    private int bytesOut;
    private int bwAudio;
    private int bwVideo;
    private int nclients;

    private String status;//publishing
    private String active;//active

    @Setter
    private Video video;
    @Setter
    private Audio audio;

    private List<Clients> client;

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "name":name = ((String) value);break;
            case "time":time = (Integer.parseInt(String.valueOf(value)));break;
            case "bw_in":bwIn = (Integer.parseInt(String.valueOf(value)));break;
            case "bytes_in":bytesIn = (Integer.parseInt(String.valueOf(value)));break;
            case "bw_out":bwOut = (Integer.parseInt(String.valueOf(value)));break;
            case "bytes_out":bytesOut = (Integer.parseInt(String.valueOf(value)));break;
            case "bw_audio":bwAudio = (Integer.parseInt(String.valueOf(value)));break;
            case "bw_video":bwVideo = (Integer.parseInt(String.valueOf(value)));break;
            case "nclients":nclients = (Integer.parseInt(String.valueOf(value)));break;
            case "publishing":status = tagName;break;
            case "active":active = tagName;break;
            default:break;
        }
    }

    public void setClient(Clients client) {
        if (this.client == null){
            this.client = new ArrayList<>();
        }
        this.client.add(client);
    }
}
