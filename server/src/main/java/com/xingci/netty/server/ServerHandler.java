package com.xingci.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ServerHandler v0.1 2020/1/17 16:39 By Kevin.
 * @description :
 */
@Slf4j
@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("server received: {}", msg);

        ctx.writeAndFlush("ok");
    }
}
