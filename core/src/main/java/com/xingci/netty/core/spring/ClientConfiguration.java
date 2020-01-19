package com.xingci.netty.core.spring;

import com.xingci.netty.core.client.ClientRequestHandler;
import com.xingci.netty.core.client.ConnectionManager;
import org.springframework.context.annotation.Bean;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ClientConfiguration v0.1 2020/1/19 10:20 By Kevin.
 * @description :
 */
public class ClientConfiguration {

    @Bean
    public ConnectionManager connectionManager() {
        return new ConnectionManager();
    }

    @Bean
    public ClientRequestHandler clientRequestHandler() {
        return new ClientRequestHandler();
    }
}
