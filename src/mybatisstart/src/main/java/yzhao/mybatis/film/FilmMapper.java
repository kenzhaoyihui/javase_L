package yzhao.mybatis.film;

import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

// Data access interface

public interface FilmMapper {

    public List<Film> getAllFilm();

    public Film getFilmById(int id);

    public void insertFilm(Film film);

    public void updateFilm(Film film);

    public void deleteFilm(@Param("ID") int id);
}
