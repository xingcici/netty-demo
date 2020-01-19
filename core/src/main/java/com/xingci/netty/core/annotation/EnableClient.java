package com.xingci.netty.core.annotation;

import com.xingci.netty.core.spring.ClientConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author : Haifeng.Pang.
 * @version 0.1 : EnableClient v0.1 2020/1/19 09:59 By Kevin.
 * @description :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ClientConfiguration.class)
public @interface EnableClient {
}
