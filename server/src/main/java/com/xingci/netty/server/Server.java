package com.xingci.netty.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : Server v0.1 2020/1/17 17:17 By Kevin.
 * @description :
 */
@Component
public class Server implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("line");
    }
}
