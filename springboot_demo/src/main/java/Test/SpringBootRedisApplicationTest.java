//package Test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import springboot_redis.dao.RedisDao;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class SpringBootRedisApplicationTest {
//
//    public static Logger logger = LoggerFactory.getLogger(SpringBootRedisApplicationTest.class);
//
//    @Test
//    public void contextLoads() {
//
//    }
//
//    @Autowired
//    RedisDao redisDao;
//
//    @Test
//    public void testRedis() {
//        redisDao.setKey("name", "zyh");
//        redisDao.setKey("age", "23");
//        logger.info(redisDao.getValue("name"));
//        logger.info(redisDao.getValue("age"));
//
//    }
//}
