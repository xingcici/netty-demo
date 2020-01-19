package com.xingci.netty.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : NettyResponse v0.1 2020/1/19 10:11 By Kevin.
 * @description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NettyResponse {

    private String requestId;

    private String msg;
}
