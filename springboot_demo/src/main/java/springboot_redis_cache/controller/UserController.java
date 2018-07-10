package springboot_redis_cache.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot_redis_cache.domain.User;
import springboot_redis_cache.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public int addUser(@RequestParam("name") String name, @RequestParam("age") String age) {
        return userService.addUser(name, age);
    }

    @RequestMapping("/find")
    public User findUser(@RequestParam("id") String id) {
        return userService.findById(id);
    }

    @RequestMapping("/update")
    public String updateById(@RequestParam("id") String id, @RequestParam("name") String name,
                             @RequestParam("age") String age) {
        try {
            userService.updateById(id, name, age);
        }catch (Exception e) {
            return "error";
        }

        return "success";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") String id) {
        try {
            userService.deleteById(id);
        }catch (Exception e) {
            return "error";
        }

        return "success";
    }


}
