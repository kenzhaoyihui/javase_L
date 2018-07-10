package springboot_redis_cache.service;

import springboot_redis_cache.domain.User;

public interface UserService {

    User findById(String id);

    int addUser(String name, String age);

    void updateById(String id, String name, String age);

    void deleteById(String id);


}
