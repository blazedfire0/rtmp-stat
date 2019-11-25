package com.rtmp.bridge;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:07
 * @描述 实现发送消息的统一接口
 */
public interface MessageImplementor {

    /**
     *
     * 功能描述:发送消息
     * @param message 要发送的消息内容
     * @param toUser 消息发送的目的人
     */
    void send(String message,String toUser);

}
