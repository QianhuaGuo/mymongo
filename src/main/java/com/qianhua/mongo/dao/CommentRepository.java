package com.qianhua.mongo.dao;

import com.qianhua.mongo.pojo.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: Watermelon
 * @Date: 2021/4/7 10:12
 */
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
