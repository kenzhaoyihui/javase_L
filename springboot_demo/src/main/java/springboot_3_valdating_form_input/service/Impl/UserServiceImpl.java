package springboot_3_valdating_form_input.service.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_3_valdating_form_input.Dao.UserRespository;
import springboot_3_valdating_form_input.domain.User;
import springboot_3_valdating_form_input.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRespository userRespository;


    @Override
    public List<User> findAll() {
        //return null;
        return userRespository.findAll();
    }

    @Override
    public User findById(Long id) {
        //return null;
        LOGGER.info("Get user id: " + id);
        return userRespository.findById(id).get();
    }

    @Override
    public User insertByUser(User user) {
        //return null;
        LOGGER.info("Add user: " + user.toString());
        return userRespository.save(user);
    }

    @Override
    public User update(User user) {
        //return null;
        LOGGER.info("Update user: " + user.toString());
        return userRespository.save(user);
    }

    @Override
    public User delete(Long id) {
        //return null;
        User user = userRespository.findById(id).get();
        userRespository.delete(user);

        LOGGER.info("Delete user: " + user.toString());
        return user;
    }
}
