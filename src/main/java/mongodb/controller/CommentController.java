package mongodb.controller;

import mongodb.entity.Comment;
import mongodb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
        commentService.saveComment(comment);
    }

    @RequestMapping("test2")
    public void test2(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);

    }
}
