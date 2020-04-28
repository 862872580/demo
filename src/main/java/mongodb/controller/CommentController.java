package mongodb.controller;

import mongodb.entity.Comment;
import mongodb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("test")
    public void test(){
        Comment comment = new Comment();
        System.out.println(comment);
        comment.setId("1");
        commentService.saveComment(comment);
    }

    @RequestMapping("test2")
    public void test2(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @RequestMapping("test3")
    public void test3(){
        Page<Comment> comments = commentService.findByParentid("1", 1, 2);
        System.out.println(comments.getTotalElements());    //返回对象个数
        System.out.println(comments.getTotalPages());       //返回对象页数
        System.out.println(comments);
    }

    @RequestMapping("test4")
    public void test4(){
        commentService.updateCommentLikeNum("1");
    }
}
