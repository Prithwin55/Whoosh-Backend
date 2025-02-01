package com.whoosh_backend.Whoosh_Backend.data.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whoosh_backend.Whoosh_Backend.data.service.RedisService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class RedisServiceImpl implements RedisService {

    RedisTemplate<String,Object> redisTemplate;

    @Override
    public <T> T get(String key, Class<T> entity) {
        try{
            ObjectMapper objectMapper=new ObjectMapper();

            Object  obj=redisTemplate.opsForValue().get(key);

            return objectMapper.readValue(obj.toString(),entity);

        }
        catch(Exception e){
            log.error("No Such value");
        }
        return null;
    }

    @Override
    public void set(String key, Object o, Long ttl) {
        try {
            redisTemplate.opsForValue().set(key,o,ttl, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("Error Setting value in redis");
        }

    }

    @Override
    public void delete(String key) {
        try {
            redisTemplate.delete(key);
        }catch (Exception e) {
            log.error("Error Deleting value");
        }
    }
}
