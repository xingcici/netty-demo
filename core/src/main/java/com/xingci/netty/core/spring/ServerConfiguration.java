package com.xingci.netty.core.spring;

import com.xingci.netty.core.server.ServerChannelInitializer;
import com.xingci.netty.core.server.ServerHandler;
import com.xingci.netty.core.server.ServiceStarter;
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
    public ServerHandler serverHandler() {
        return new ServerHandler();
    }
}
