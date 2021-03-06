package com.xingci.netty.server;

import com.xingci.netty.core.annotation.EnableServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : Application v0.1 2020/1/17 16:39 By Kevin.
 * @description :
 */
@SpringBootApplication
@EnableServer
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
