package springboot_jpa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_jpa.dao.AccountDao;
import springboot_jpa.entity.Account;
import springboot_jpa.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;


    @Override
    public List<Account> findAll() {
        //return null;
        return accountDao.findAll();
    }

    @Override
    public Account insertAccount(Account account) {
        //return null;
        return accountDao.save(account);
    }

    @Override
    public Account update(Account account) {
        //return null;
        return accountDao.save(account);
    }

    @Override
    public Account delete(Integer id) {
        //return null;
        Account account = accountDao.findById(id).get();
        accountDao.delete(account);
        return account;
    }

    @Override
    public Account findById(Integer id) {
        //return null;
        return accountDao.findById(id).get();
    }

}
