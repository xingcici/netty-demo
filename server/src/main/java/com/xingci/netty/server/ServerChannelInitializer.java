package com.xingci.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ServerChannelInitializer v0.1 2020/1/17 16:39 By Kevin.
 * @description :
 */

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Autowired
    private ServerHandler serverHandler;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 4))
                .addLast(new LengthFieldPrepender(4, false))
                .addLast(serverHandler);
    }
}
