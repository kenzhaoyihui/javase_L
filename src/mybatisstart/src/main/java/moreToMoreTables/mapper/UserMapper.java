package moreToMoreTables.mapper;

import moreToMoreTables.pojo.Group;
import moreToMoreTables.pojo.User;

import java.util.List;

public interface UserMapper {
    public void insertUser(User user);
    public User getUser(int id);
}
