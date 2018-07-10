//package springboot_redis3.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import springboot_redis3.entity.User;
//import springboot_redis3.service.RedisService;
//
//@RestController
//@RequestMapping("/redis")
//public class RedisController {
//
//    @Autowired
//    RedisService redisService;
//
//    @RequestMapping(value = "setStr")
//    public String setStr(String key, String val) {
//        try {
//            redisService.setStr(key, val);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//
//        return "success";
//    }
//
//    @RequestMapping("getStr")
//    public String getStr(String key) {
//        return redisService.getStr(key);
//    }
//
//    @RequestMapping("/delStr")
//    public String delStr(String key) {
//        try {
//            redisService.delStr(key);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//
//        return "success";
//    }
//
//    @RequestMapping("/setObj")
//    public String setObj(String key, User user) {
//        try {
//            redisService.setObj(key, user);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//
//        return "success";
//    }
//
//    @RequestMapping("/getObj")
//    public Object getObj(String key) {
//        return redisService.getObj(key);
//    }
//
//    @RequestMapping("/delObj")
//    public String delObj(String key) {
//        try {
//            redisService.delObj(key);
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//
//        return "success";
//    }
//}
