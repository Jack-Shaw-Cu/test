package com.test1.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author XT
 * @Title: RedisUtils
 * @Date: 2024/5/17 18:27
 * @description: redis工具类
 */
@Component
@Slf4j
public class RedisUtils {

    @Resource
    private  RedisTemplate<String,Object> redisTemplate;

    /**
     * 写入缓存
     * @param key redis缓存
     * @param value redis缓存
     * @return 是否成功
     */
    public boolean set(final String key, Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            log.info("存入redis成功: key: {},value: {}",key,value);
            return true;
        }catch (Exception e){
            log.error("set错误",e);
        }
        return false;
    }

    /**
     * 写入缓存并设置失效时间
     * @param key 缓存key
     * @param value 缓存value
     * @param expireTime 缓存失效时间
     * @return 是否成功
     */
    public boolean set(final String key, Object value, Long expireTime){
        try {
            redisTemplate.opsForValue().set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            return true;
        }catch (Exception e){
            log.error("set时间错误",e);
        }
        return false;
    }

    /**
     * 批量删除key
     * @param keys 缓存key
     * @description: stringRedisTemplate.hasKey(key) 该方法返回值为Boolean可能为null
     */
    public void removeByKeys(List<String> keys){
        for (String key : keys) {
            if(hasKey(key)){
                redisTemplate.delete(key);
            }
        }
    }

    /**
     * 判断key是否存在
     * @param key 缓存key
     * @return 是否存在
     */
    public boolean hasKey(String key){
        return Objects.equals(redisTemplate.hasKey(key),Boolean.TRUE);
    }

    /**
     * 根据key返回value
     * @param key 缓存key
     * @return value
     */
    public Object get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

}
