//package springboot_redis3.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @Resource(name = "stringRedisTemplate")
//    ValueOperations<String, String> valOpsStr;
//
//    @Autowired
//    RedisTemplate<Object, Object> redisTemplate;
//
//    @Resource(name = "redisTemplate")
//    ValueOperations<Object, Object> valOpsObj;
//
//
//    public String getStr(String key) {
//        return valOpsStr.get(key);
//    }
//
//    public void setStr(String key, String val) {
//        valOpsStr.set(key, val);
//    }
//
//    public void delStr(String key) {
//        stringRedisTemplate.delete(key);
//    }
//
//
//    /**
//     * By redisTemplate (Object)
//     */
//
//    public Object getObj(Object o) {
//        return valOpsObj.get(o);
//    }
//
//    public void setObj(Object obj1, Object obj2) {
//        valOpsObj.set(obj1, obj2);
//    }
//
//    public void delObj(Object o) {
//        redisTemplate.delete(o);
//    }
//}
