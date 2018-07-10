package springboot_mybatis.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springboot_mybatis.service.Accountservice2;

@RestController
@RequestMapping("/account")
@MapperScan("springboot_mybatis.dao")
public class AccountController2 {

    @Autowired
    Accountservice2 accountservice2;

    @RequestMapping(value = "transfer", method = RequestMethod.GET)
    public void transfer() {
        accountservice2.transfer();
    }
}
