package com.rtmp.bridge.send;

import com.rtmp.bridge.AbstractMessage;
import com.rtmp.bridge.MessageImplementor;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:18
 * @描述 普通消息
 */
public class CommonMessage extends AbstractMessage {
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
