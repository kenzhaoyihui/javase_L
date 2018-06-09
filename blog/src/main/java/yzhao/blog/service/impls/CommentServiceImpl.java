package yzhao.blog.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yzhao.blog.bean.Comment;
import yzhao.blog.dao.CommentMapper;
import yzhao.blog.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    public CommentMapper commentMapper;


    @Override
    public List<Comment> getAllComments(int article_id, int offset, int limit) {
        //return null;
        return commentMapper.queryAll(article_id, offset, limit);
    }

    @Override
    public int insertComment(Comment comment) {
        //return 0;
        return commentMapper.insertSelective(comment);
    }

    @Override
    public int countAllNum() {
        //return 0;
        return commentMapper.countAllNum();
    }

    @Override
    public boolean delById(Long id) {
        //return false;
        return commentMapper.deleteByPrimaryKey(id)>0;
    }
}
