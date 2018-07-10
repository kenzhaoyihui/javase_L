package springboot_mybatis.service;

import springboot_mybatis.bean.Account;

import java.util.List;

public interface AccountService {

    int add(String name, double money);

    int update(String name, double money, int id);

    int delete(int id);

    List<Account> findAccountList();

    Account findAccountById(int id);


}
