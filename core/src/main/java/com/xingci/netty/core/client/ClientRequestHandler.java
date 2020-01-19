package com.xingci.netty.core.client;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ClientRequestHandler v0.1 2020/1/19 10:31 By Kevin.
 * @description :
 */
public class ClientRequestHandler {

    @Autowired
    private ConnectionManager connectionManager;


    public ClientHandler geHandler(Integer port) {
        return connectionManager.getClientHandler(port);
    }
}
