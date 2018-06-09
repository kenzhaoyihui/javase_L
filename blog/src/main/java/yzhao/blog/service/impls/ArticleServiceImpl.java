package yzhao.blog.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yzhao.blog.bean.Article;
import yzhao.blog.dao.ArticleMapper;
import yzhao.blog.service.ArticleService;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    public ArticleMapper articleMapper;

    @Override
    public Article selectById(Integer id) {
        //return null;
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Article selectLastArticle(Integer id) {
        //return null;
        return articleMapper.selectLastArticle(id);
    }

    @Override
    public Article selectNextArticle(Integer id) {
        //return null;
        return articleMapper.selectNextArticle(id);
    }

    @Override
    public List<Article> queryAll() {
        //return null;
        return articleMapper.queryAll();
    }

    @Override
    public int countAllNum() {
        //return 0;
        return articleMapper.countAllNum();
    }

    @Override
    public boolean updateArticle(Article article) {
        //return false;
        return articleMapper.updateByPrimaryKeySelective(article)>0;
    }

    @Override
    public int deleteById(Integer id) {
        //return 0;
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int selectCount() {
        //return 0;
        return articleMapper.countAllNum();
    }

    @Override
    public List<Article> selectByWord(String word) {
        //return null;
        return articleMapper.selectByWord(word);
    }

    @Override
    public boolean insert(Article article) {
        //return false;
        return articleMapper.insertSelective(article)>0;
    }
}
