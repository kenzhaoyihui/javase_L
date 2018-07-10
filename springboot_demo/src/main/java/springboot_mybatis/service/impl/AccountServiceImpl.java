package springboot_mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_mybatis.bean.Account;
import springboot_mybatis.dao.AccountDao;
import springboot_mybatis.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountDao accountDao;

    @Override
    public int add(String name, double money) {
        //return 0;
        return accountDao.add(name, money);
    }

    @Override
    public int update(String name, double money, int id) {
        //return 0;
        return accountDao.update(name, money, id);
    }

    @Override
    public int delete(int id) {
        //return 0;
        return accountDao.delete(id);
    }

    @Override
    public List<Account> findAccountList() {
        //return null;
        return accountDao.findAccountList();
    }

    @Override
    public Account findAccountById(int id) {
        //return null;
        return accountDao.findAccountById(id);
    }
}
