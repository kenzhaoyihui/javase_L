package springboot_jpa.service;

import springboot_jpa.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account insertAccount(Account account);

    Account update(Account account);

    Account delete(Integer id);

    Account findById(Integer id);
}
