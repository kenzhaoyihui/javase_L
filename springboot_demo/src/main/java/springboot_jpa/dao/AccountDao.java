package springboot_jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_jpa.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {
}
