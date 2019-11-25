package com.rtmp.bridge.send;

import com.rtmp.bridge.MessageImplementor;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:16
 * @描述 TODO
 */
public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用Email的方式，发送消息'"+message+"'给"+toUser);
    }
}
