package mongodb.service;

import mongodb.entity.Comment;
import mongodb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //保存评论
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    //跟新评论
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    //删除评论
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    //查询所有评论
    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }

    //根据id查询评论
    public void findCommentById(String id){
        commentRepository.findById(id).get();
    }

}
