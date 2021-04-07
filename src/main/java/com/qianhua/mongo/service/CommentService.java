package com.qianhua.mongo.service;

import com.qianhua.mongo.dao.CommentRepository;
import com.qianhua.mongo.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Watermelon
 * @Date: 2021/4/7 10:14
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一个评论
     * @param comment
     */
    public void saveComment(Comment comment){
        //如果需要自定义主键，可以在这里指定主键；如果不指定主键，Mongodb会自动生成主键
        commentRepository.save(comment);
    }

    /**
     * 更新评论
     * @param comment
     */
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 根据id删除评论
     * @param id
     */
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    /**
     * 查询所有评论
     * @return
     */
    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }

    /**
     * 根据id查询评论
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }


    public Page<Comment> findCommentListByParentid(String parentid,int page,int size){
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));
    }

    /**
     * 点赞数+1
     * @param id
     */
    public void updateCommentLikenum(String id){
        Query query = Query.query(Criteria.where("_id").is(id));//查询条件
        Update update = new Update();
        update.inc("likenum");
        mongoTemplate.updateFirst(query,update,"comment");
    }

    /**
     * 取消点赞-1
     * @param id
     */
    public void decUpdateCommentLikenum(String id){
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("likenum",-1);
        mongoTemplate.updateFirst(query,update,"comment");
    }
}
