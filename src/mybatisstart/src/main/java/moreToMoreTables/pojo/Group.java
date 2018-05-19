package moreToMoreTables.pojo;

import java.util.List;

public class Group {
    private int groupId;
    private String groupName;
    private List<User> users;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }
}
