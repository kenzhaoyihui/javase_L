package moreToMoreTables.mapper;

import moreToMoreTables.pojo.Group;
import moreToMoreTables.pojo.User;
import moreToMoreTables.pojo.UserGroup;

import java.util.List;

public interface UserGroupMapper {
    public void insertUserGroup(UserGroup userGroup);
    public List<Group> getGroupsByUserId(int id);
    public List<User> getUsersByGroupId(int id);
}
