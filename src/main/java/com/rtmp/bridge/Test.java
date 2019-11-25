package com.rtmp.bridge;

import com.rtmp.bridge.send.CommonMessage;
import com.rtmp.bridge.send.MessageEmail;
import com.rtmp.bridge.send.MessageSMS;
import com.rtmp.bridge.send.UrgencyMessage;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:21
 * @描述 TODO
 */
public class Test {

    public static void main(String[] args) {
        //创建具体的实现对象
        MessageSMS sms = new MessageSMS();

        //创建一个普通消息对象
        AbstractMessage m = new CommonMessage(sms);
        m.sendMessage("请喝一杯茶", "小李");
        //创建一个紧急消息对象
        m = new UrgencyMessage(sms);
        m.sendMessage("请喝一杯茶", "小李");

        MessageEmail email = new MessageEmail();
        AbstractMessage m2 = new CommonMessage(email);
        m2.sendMessage("请喝一杯茶", "小李");
        //创建一个紧急消息对象
        m2 = new UrgencyMessage(email);
        m2.sendMessage("请喝一杯茶", "小李");
    }
}
