package moreToMoreTables.mapper;

import moreToMoreTables.pojo.Group;
import moreToMoreTables.pojo.User;

import java.util.List;

public interface GroupMapper {
    public void insertGroup(Group group);
    public Group getGroup(int id);
}
