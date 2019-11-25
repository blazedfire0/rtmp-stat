package com.rtmp.bridge;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:09
 * @描述 抽象消息对象
 */
public abstract class AbstractMessage {

    //持有一个实现部分的对象
    protected MessageImplementor impl;


    //构造方法 传入实现部分对象
    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    //发送消息，转调实现部分方法
    public void sendMessage(String message,String toUser){
        this.impl.send(message, toUser);
    }
}
