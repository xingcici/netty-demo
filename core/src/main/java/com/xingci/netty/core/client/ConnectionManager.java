package com.xingci.netty.core.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.ConnectException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ConnectionManager v0.1 2020/1/19 10:19 By Kevin.
 * @description :
 */
@Slf4j
public class ConnectionManager {

    private EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    private ConcurrentHashMap<String, ClientHandler> handlers = new ConcurrentHashMap<>();

    public ClientHandler getClientHandler(Integer port) {
        return connect(port);
    }

    private ClientHandler connect(Integer port) {
        Bootstrap bootstrap = new Bootstrap();
        ClientChannelInitializer channelInitializer = new ClientChannelInitializer();
        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(channelInitializer)
                    .option(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture connectFuture = bootstrap.connect("localhost", port).sync();
            connectFuture.sync();
            return channelInitializer.getClientHandler();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
