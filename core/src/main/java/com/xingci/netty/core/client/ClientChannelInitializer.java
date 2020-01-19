package com.xingci.netty.core.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ClientChannelInitializer v0.1 2020/1/19 10:17 By Kevin.
 * @description :
 */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ClientHandler clientHandler = new ClientHandler();

    public ClientHandler getClientHandler() {
        return clientHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 4))
                .addLast(new LengthFieldPrepender(4, false))
                .addLast(clientHandler);
    }
}
