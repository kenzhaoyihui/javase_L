package springboot_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot_mybatis.bean.Account;
import springboot_mybatis.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountService.findAccountList();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t = accountService.update(name, money, id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) {
        int t = accountService.delete(id);
        if (t==1) {
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String addAccount(@RequestParam("name") String name,
                             @RequestParam("money") double money) {
        int t = accountService.add(name, money);
        if (t==1) {
            return "success";
        }else {
            return "fail";
        }
    }
}
