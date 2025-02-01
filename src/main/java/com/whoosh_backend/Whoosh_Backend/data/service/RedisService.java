package com.whoosh_backend.Whoosh_Backend.data.service;

public interface RedisService {
    public <T> T get(String key,Class <T> entity);

    public void set(String key,Object o,Long ttl);

    public void delete(String key);

}
