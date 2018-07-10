package springboot_redis_cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springboot_redis_cache.dao.UserMapper;
import springboot_redis_cache.domain.User;
import springboot_redis_cache.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(String id) {
        //return null;
        return userMapper.findById(id);
    }

    @Override
    public void updateById(String id, String name, String age) {
        userMapper.updateById(id, name, age);

    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public int addUser(String name, String age) {
        //return 0;
        return userMapper.addUser(name, age);
    }
}
