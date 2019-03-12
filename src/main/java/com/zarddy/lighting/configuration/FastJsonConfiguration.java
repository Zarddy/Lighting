package com.zarddy.lighting.configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * <a href="https://www.jianshu.com/p/14df78573cb2">第五章：配置使用FastJson返回Json视图</a>
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect, // 消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
                SerializerFeature.WriteMapNullValue, // 是否输出值为null的字段，默认为false
                SerializerFeature.WriteNullStringAsEmpty, // 字符类型字段如果为null，输出为"", 而非null
                SerializerFeature.WriteNullBooleanAsFalse, // List类型字段如果为null，输出为[]，而非null
                SerializerFeature.WriteNullListAsEmpty // Boolean类型字段如果为null，输出为false，而非null
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonHttpMessageConverter);
    }
}
