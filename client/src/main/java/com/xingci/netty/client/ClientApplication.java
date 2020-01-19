package com.xingci.netty.client;

import com.google.common.util.concurrent.SettableFuture;
import com.xingci.netty.core.annotation.EnableClient;
import com.xingci.netty.core.client.ClientHandler;
import com.xingci.netty.core.client.ClientRequestHandler;
import com.xingci.netty.core.domain.NettyRequest;
import com.xingci.netty.core.domain.NettyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : Application v0.1 2020/1/17 16:39 By Kevin.
 * @description :
 */
@SpringBootApplication
@EnableClient
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(ClientRequestHandler clientRequestHandler) {
        return (String... args) -> {

            ClientHandler clientHandler = clientRequestHandler.geHandler(26027);
            SettableFuture<NettyResponse> future = clientHandler.sendRequest(new NettyRequest(UUID.randomUUID().toString(), "Hello Netty"));
            System.out.println(future.get());
        };
    }
}
