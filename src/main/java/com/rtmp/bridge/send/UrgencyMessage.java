package com.rtmp.bridge.send;

import com.rtmp.bridge.AbstractMessage;
import com.rtmp.bridge.MessageImplementor;

/**
 * @作者 LEIJIE
 * @时间 2019-11-25 14:19
 * @描述 加急消息
 */
public class UrgencyMessage extends AbstractMessage {
    public UrgencyMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage("【加急】"+message, toUser);
    }

    /**
     * 扩展自己的新功能：监控某消息的处理过程
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象，这里示意一下，所以用了Object
     */
    public Object watch(String messageId) {
        //获取相应的数据，组织成监控的数据对象，然后返回
        return null;
    }
}
