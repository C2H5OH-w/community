package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //设施key序列化方式
        template.setKeySerializer(RedisSerializer.string());
        // value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
        //hash的key序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
        //hash的value序列化方式
        template.setValueSerializer(RedisSerializer.json());

        template.afterPropertiesSet();

        return template;
    }
}
