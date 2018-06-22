package Test;

import com.example.StartApp;
import com.example.bean.SystemUser;
import com.example.service.SystemUserService;
import com.example.service.impl.SystemUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartApp.class)
public class TestJDBC {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SystemUserService systemUserService;

    @Test
    public void saveUser() {
        SystemUser user = new SystemUser();
        user.setStatus(1);
        user.setRegisterDate(new Date());
        user.setPassword("12345678");
        user.setIsRoot("1");
        user.setUsername("testyzhao1234");
        systemUserService.saveUsers(user);
        //String uuid = systemUserService.saveUsers(user);

//        logger.info("Add successfully: uuid: {}", uuid);
    }

    @Test
    public void deleteUserByUsername() {
        String username = "testyzhao";
        systemUserService.deleteUserByUsername(username);
    }

    @Test
    public void findAllUsers() {
        List<SystemUser> list = systemUserService.findAllUser();

        Iterator<SystemUser> iterator = list.iterator();
        while (iterator.hasNext()) {
            //System.out.println(iterator.next());
            logger.info(iterator.next().getUsername());
        }
        //return list;
    }

    @Test
    public void updateUser() {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername("testyzhao1234");

        systemUser.setPassword("redhat");
        systemUser.setStatus(0);

        systemUserService.updateUser(systemUser);
    }
}

