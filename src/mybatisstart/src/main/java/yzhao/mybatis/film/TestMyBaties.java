package yzhao.mybatis.film;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBaties extends TestCase{

    public void testBaties() throws IOException{
        //Configura file
        String resource = "mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //SqlSessionFactory from SqlSessionFactoryBuilder
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = null;

        try{

            // Get SqlSession
            session = sqlSessionFactory.openSession();

            //DAO interface
            FilmMapper mapper = session.getMapper(FilmMapper.class);

            //CRUD operation

            // 5.1
            Film film = new Film();
            film.setFname("mylove");
            mapper.insertFilm(film);
            session.commit();

            //5.2
            film = mapper.getFilmById(1);
            film.setFname("laopaoer");
            mapper.updateFilm(film);
            session.commit();

            //5.3
            mapper.deleteFilm(3);
            session.commit();

            //5.4
            List<Film> filmList = mapper.getAllFilm();

            for (Film obj: filmList){
                System.out.println("ID: " + obj.getId() + " , FilmName: " + obj.getFname());
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
