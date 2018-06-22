package Test;


import com.example.StartApp;
import com.example.bean.SystemUser;
import com.example.mapper.SystemUserMapper;
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
public class TestMyBatis {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SystemUserMapper systemUserMapper;

    @Test
    public void saveUser() {
        SystemUser user = new SystemUser();
        user.setStatus(1);
        user.setRegisterDate(new Date());
        user.setPassword("ljljlj");
        user.setIsRoot("1");
        user.setUsername("ljljlj");
        systemUserMapper.saveUser(user);
        //String uuid = systemUserService.saveUsers(user);

//        logger.info("Add successfully: uuid: {}", uuid);
    }

    @Test
    public void deleteUserByUsername() {
        String username = "testyzhao123";
        systemUserMapper.deleteUserByUsername(username);
    }

    @Test
    public void findAllUsers() {
        List<SystemUser> list = systemUserMapper.findAllUsers();

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

        systemUser.setPassword("redhat123");
        systemUser.setStatus(0);

        systemUserMapper.updateUser(systemUser);
    }

    @Test
    public void findUserByUsername() {
        String username = "ljljlj";
        logger.info(systemUserMapper.findUserByUsername(username).getPassword());
        logger.info(systemUserMapper.findUserByUsername(username).getIsRoot());
        logger.info(systemUserMapper.findUserByUsername(username).getStatus().toString());
        logger.info(systemUserMapper.findUserByUsername(username).getUuid().toString());
        logger.info(systemUserMapper.findUserByUsername(username).getRegisterDate().toString());
    }
}


