package userpost;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static InputStream inputStream;

    static{
        try{
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public static void main(String[] args){
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        try{
//            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            User user = sqlSession.selectOne("userpost.UserMapper.getUser", 1);
////            user.setId(1);
//            System.out.println("username: " + user.getUsername());
//            System.out.println("User: " + userMapper.getUser(1));
////
//            List<Post> posts = user.getPosts();
//            for(Post p : posts){
//                System.out.println("Title: " + p.getTitle());
//                System.out.println("Content: " + p.getContent());
//            }
//        }finally {
//            sqlSession.close();
//        }
//
        try{
            Post post = sqlSession.selectOne("userpost.UserMapper.getPosts", 1);
            System.out.println("title: " + post.getTitle());
            System.out.println("Content: " + post.getContent());
            System.out.println("Username: " + post.getUser().getUsername() + " , Mobile: " + post.getUser().getMobile());
        }finally {
            sqlSession.close();
        }
    }
}
