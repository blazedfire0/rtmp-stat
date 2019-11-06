package com.rtmp;

import com.rtmp.bean.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class RtmpStatApplicationTests {

    static String url = "http://192.168.100.199:8035/stat";
    private CountDownLatch latch = new CountDownLatch(5);
    @Test
    public void contextLoads() throws InterruptedException {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("<<<<<<<<< start >>>>>>>>");
                    RtmpState rtmpState = StateAnalysis.runJob(url);
                    List<Application> appList = rtmpState.getServer();
                    for (Application application : appList) {
                        List<LiveStreams> streamsList = application.getLiveStreams();
                        if ("live".equalsIgnoreCase(application.getName()) && streamsList != null){
                            for (LiveStreams liveStreams : streamsList) {
                                List<Clients> clientsList = liveStreams.getClient();
                                System.out.println(liveStreams.getName()+"的clients数量:"+liveStreams.getNclients());
                                for (Clients clients : clientsList) {
                                    System.out.println(clients.getType()+"("+clients.getAddress()+")"+
                                            " video=" +StateAnalysis.readableFileSize(liveStreams.getBwVideo())+
                                            " audio=" +StateAnalysis.readableFileSize(liveStreams.getBwAudio())+
                                            " 持续时间="+new BigDecimal(clients.getTime()).divide(new BigDecimal(60*1000),2,BigDecimal.ROUND_DOWN).doubleValue());
                                }
                                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                            }
                            System.out.println("-------------------------------------");
                        }
                    }
                    System.out.println("<<<<<<<<< end >>>>>>>>");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    latch.countDown();
                }
            }
        },1000,10000);
        latch.await();
    }

}
