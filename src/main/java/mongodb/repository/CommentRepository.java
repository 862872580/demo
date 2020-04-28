package mongodb.repository;

import mongodb.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {

    //根据父id进行分页查询
    Page<Comment> findByParentid(String parent, Pageable pageable);

}
