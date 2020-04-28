package mongodb.service;

import mongodb.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;
    @Test
    public void testFindCommentList(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }
}
