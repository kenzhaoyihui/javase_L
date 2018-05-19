package moreToMoreTables;

import moreToMoreTables.mapper.GroupMapper;
import moreToMoreTables.mapper.UserGroupMapper;
import moreToMoreTables.mapper.UserMapper;
import moreToMoreTables.pojo.Group;
import moreToMoreTables.pojo.User;
import moreToMoreTables.pojo.UserGroup;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class TestMain {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // testAddGroup();
        // testAddUser();
        // testAddUserGroup();
        testGetGroupAndUsers();

    }

    public static void testGetGroupAndUsers() {
        UserGroup userGroup = new UserGroup();
        SqlSession session = sqlSessionFactory.openSession();
//        try {
//            GroupMapper groupMaper = session.getMapper(GroupMapper.class);
//            Group group = groupMaper.getGroup(1);
//            System.out.println("Group => " + group.getGroupName());
//            List<User> users = group.getUsers();
//            for (User user : users) {
//                System.out.println("\t:" + user.getId() + "\t"
//                        + user.getUsername());
//            }
//        } finally {
//            session.close();
//        }

        try{
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.getUser(1);
            System.out.println("User: " + user.getUsername());
            List<Group> groups = user.getGroups();
            for(Group group: groups){
                System.out.println("GroupId: " + group.getGroupId() + ", GroupName: " + group.getGroupName());
            }

        }finally {
            session.close();
        }
    }

    public static void testAddUserGroup() {
        UserGroup userGroup = new UserGroup();
        userGroup.setGroupId(1);
        userGroup.setUserId(3);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserGroupMapper userGroupMaper = session
                    .getMapper(UserGroupMapper.class);
            userGroupMaper.insertUserGroup(userGroup);

            session.commit();
        } finally {
            session.close();
        }

    }

    public static void testAddUser() {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setUsername("User-name-2");
            user.setMobile("13838009988");
            UserMapper userMaper = session.getMapper(UserMapper.class);
            userMaper.insertUser(user);
            session.commit();
            // System.out.println(user.getGroupId());
        } finally {
            session.close();
        }
    }

    public static void testAddGroup() {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Group group = new Group();
            group.setGroupName("用户组-1");
            GroupMapper groupMapper = session.getMapper(GroupMapper.class);
            groupMapper.insertGroup(group);
            session.commit();
            System.out.println(group.getGroupId());
        } finally {
            session.close();
        }
    }
}
