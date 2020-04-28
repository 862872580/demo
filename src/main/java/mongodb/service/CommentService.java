package mongodb.service;

import mongodb.entity.Comment;
import mongodb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

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

    public Page<Comment> findByParentid(String parentid, int page, int size){
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1, size));
    }

    public void updateCommentLikeNum(String id){
        //查询条件
        Query query = Query.query(Criteria.where("_id").is(id));

        //跟新条件
        Update update = new Update();
        //key:跟新的参数  inc:加的数额
        update.inc("likenum",1);

        mongoTemplate.updateFirst(query, update, Comment.class);
    }
}
