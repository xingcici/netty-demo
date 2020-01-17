package com.xingci.netty.server;

import org.springframework.context.annotation.Bean;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ServerConfiguration v0.1 2020/1/17 17:28 By Kevin.
 * @description :
 */
public class ServerConfiguration {

    @Bean
    public ServiceStarter serviceStarter() {
        return new ServiceStarter();
    }

    @Bean
    public ServerChannelInitializer serverChannelInitializer() {
        return new ServerChannelInitializer();
    }

    @Bean
    public ServerHandler rpcServerHandler() {
        return new ServerHandler();
    }
}
