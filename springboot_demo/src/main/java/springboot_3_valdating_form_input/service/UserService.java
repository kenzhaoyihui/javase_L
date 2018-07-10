package springboot_3_valdating_form_input.service;

import springboot_3_valdating_form_input.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
