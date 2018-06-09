package yzhao.blog.service;

import yzhao.blog.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments(int article_id, int offset, int limit);

    int insertComment(Comment comment);

    int countAllNum();

    boolean delById(Long id);
}
