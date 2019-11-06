package com.rtmp.bean;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 12:45
 * @描述 TODO
 */
@Getter
public class RtmpState extends SuperValue{

    private String nginxVersion;
    private String nginxRtmpVersion;
    private String compiler;
    private String built;
    private int pid;
    private int uptime;//Time
    private int naccepted;
    private int bwIn;//In bits/s 除1024
    private String bytesIn;//In bytes 除1024*2
    private int bwOut;//Out bits/s
    private String bytesOut;//In bytes 除1024*2

    private List<Application> server;

    @Override
    public void setValue(String tagName,Object value){
        switch (tagName){
            case "nginx_version":nginxVersion = ((String) value);break;
            case "nginx_rtmp_version":nginxRtmpVersion = ((String) value);break;
            case "compiler":compiler = ((String) value);break;
            case "built":built = ((String) value);break;
            case "pid":pid = (Integer.parseInt(String.valueOf(value)));break;
            case "uptime":uptime = (Integer.parseInt(String.valueOf(value)));break;
            case "naccepted":naccepted = (Integer.parseInt(String.valueOf(value)));break;
            case "bw_in":bwIn = (Integer.parseInt(String.valueOf(value)));break;
            case "bytes_in":bytesIn = String.valueOf(value);break;
            case "bw_out":bwOut = (Integer.parseInt(String.valueOf(value)));break;
            case "bytes_out":bytesOut = String.valueOf(value);break;
            default:break;
        }
    }

    public void setServer(Application application) {
        if (this.server == null){
            this.server = new ArrayList<>();
        }
        this.server.add(application);
    }
}
