package com.xingci.netty.core.client;

import com.google.common.util.concurrent.SettableFuture;
import com.xingci.netty.core.domain.NettyRequest;
import com.xingci.netty.core.domain.NettyResponse;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.net.SocketAddress;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : ClientHandler v0.1 2020/1/19 10:04 By Kevin.
 * @description :
 */
@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler<NettyResponse> {
    private Channel channel;
    private SocketAddress serverAddress;
    private ConcurrentHashMap<String, SettableFuture<NettyResponse>> requestContext = new ConcurrentHashMap<>(16);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        channel = ctx.channel();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        serverAddress = ctx.channel().remoteAddress();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyResponse msg) throws Exception {
        String requestId = msg.getRequestId();
        SettableFuture<NettyResponse> future = requestContext.get(requestId);
        Assert.notNull(future, "rpcResponseFuture for requestId " + requestId + " should not be null");
        requestContext.remove(requestId);
        future.set(msg);
        log.info("client received:{}", msg);
    }

    public SettableFuture<NettyResponse> sendRequest(NettyRequest request) {
        String requestId = request.getRequestId();
        SettableFuture<NettyResponse> future = SettableFuture.create();
        requestContext.put(requestId, future);
        channel.writeAndFlush(request);
        log.info("client send request:{}", request);
        return future;
    }
}
