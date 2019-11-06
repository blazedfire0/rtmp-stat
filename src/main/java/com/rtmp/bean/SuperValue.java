package com.rtmp.bean;

/**
 * @作者 LEIJIE
 * @时间 2019-9-24 17:08
 * @描述 TODO
 */
public abstract class SuperValue {

    public abstract void setValue(String tagName, Object value);

    public static RtmpState rtmpState;
    static Application application;
    static LiveStreams liveStreams;
    static Clients client;
    static Video video;
    static Audio audio;

    public static SuperValue getObjForType(int index,String type){
        switch (type){
            case "rtmp":
                if (index==0)rtmpState = new RtmpState();
                return rtmpState;
            case "application":
                if (index==0)application = new Application();
                return application;
            case "stream":
                if (index==0)liveStreams = new LiveStreams();
                return liveStreams;
            case "client":
                if (index==0)client = new Clients();
                return client;
            case "video":
                if (index==0)video = new Video();
                return video;
            case "audio":
                if (index==0)audio = new Audio();
                return audio;
            default:return null;
        }
    }

    public static void saveObj(String type){
        switch (type){
            case "rtmp":break;
            case "application":
                rtmpState.setServer(application);
                break;
            case "stream":
                application.setLiveStreams(liveStreams);
                break;
            case "client":
                liveStreams.setClient(client);
                break;
            case "video":
                liveStreams.setVideo(video);
                break;
            case "audio":
                liveStreams.setAudio(audio);
                break;
            default:break;
        }
    }
}
