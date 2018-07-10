package springboot_jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot_jpa.dao.AccountDao;
import springboot_jpa.entity.Account;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountDao accountDao;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountDao.findById(id).get();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);

        //Account account1 = accountDao.saveAndFlush(account);
        Account account1 = accountDao.save(account);
        return account1.toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {

        Account account = new Account();
        account.setMoney(money);
        account.setName(name);
        accountDao.save(account);
        Account account1 = accountDao.save(account);
        return account1.toString();
    }


}
