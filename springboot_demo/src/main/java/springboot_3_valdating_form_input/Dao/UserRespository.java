package springboot_3_valdating_form_input.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_3_valdating_form_input.domain.User;

public interface UserRespository extends JpaRepository<User, Long>{
}
