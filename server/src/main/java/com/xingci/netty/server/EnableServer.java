package com.xingci.netty.server;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Here be dragons !
 * @author: Ezio
 * 2019/12/6 11:16 上午
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServerConfiguration.class)
public @interface EnableServer {
}
