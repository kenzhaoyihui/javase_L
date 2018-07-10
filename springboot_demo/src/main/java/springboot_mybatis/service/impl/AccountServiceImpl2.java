package springboot_mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot_mybatis.dao.AccountDao2;
import springboot_mybatis.service.Accountservice2;

@Service
public class AccountServiceImpl2 implements Accountservice2 {

    @Autowired
    AccountDao2 accountDao2;

    @Transactional
    @Override
    public void transfer() throws RuntimeException {
        accountDao2.update(1000, 1);
        int i=1/0;
        accountDao2.update(1000, 2);
    }
}
