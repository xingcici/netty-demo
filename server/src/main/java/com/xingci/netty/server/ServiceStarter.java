package com.xingci.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.SocketUtils;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ServiceStarter v0.1 2020/1/17 17:28 By Kevin.
 * @description :
 */
@Slf4j
public class ServiceStarter implements CommandLineRunner {

    @Autowired
    private ServerChannelInitializer serverChannelInitializer;

    private NioEventLoopGroup bossGroup = new NioEventLoopGroup();
    private NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    public ChannelFuture start() {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(serverChannelInitializer).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            int inetPort = SocketUtils.findAvailableTcpPort();
            ChannelFuture bindFuture = serverBootstrap.bind(inetPort).sync();
            bindFuture.addListener(future -> {
                if (future.isSuccess()) {
                    log.info("netty 已成功启动 port {}", inetPort);
                } else {
                    System.exit(1);
                }
            });
            return bindFuture;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        start();
    }
}
