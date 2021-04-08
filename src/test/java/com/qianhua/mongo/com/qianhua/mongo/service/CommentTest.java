package com.qianhua.mongo.com.qianhua.mongo.service;

import com.qianhua.mongo.pojo.Comment;
import com.qianhua.mongo.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Watermelon
 * @Date: 2021/4/7 10:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void findCommentList(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList);
    }

    @Test
    public void findCommentById(){
        Comment comment = commentService.findCommentById("606d1bde4580a2797d730011");
        System.out.println(comment);
    }

    @Test
    public void saveComment(){
        Comment comment = new Comment();
        comment.setArticleid("1009");
        comment.setContent("测试添加的数据9");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1009");
        comment.setNickname("嘻嘻嘻");
        comment.setLikenum(0);
        comment.setState("1");
        comment.setReplynum(0);
        List<String> likenames = new LinkedList<>();
        likenames.add("qianhua");
        likenames.add("hahah");
        likenames.add("wulalala");
        likenames.add("jgjgjg");
        comment.setLikename(likenames);

        commentService.saveComment(comment);
    }

    @Test
    public void findCommentListByParentid(){
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getTotalElements());//总条数
        System.out.println(page.getContent());//list集合
    }

    @Test
    public void updateCommentLikenumTest(){
        commentService.updateCommentLikenum("606d1d3b1b63ba001e7bb1eb");
    }

    @Test
    public void decUpdateCommentLikenumTest(){
        commentService.decUpdateCommentLikenum("606d1d3b1b63ba001e7bb1eb");
    }
}
