package com.qianhua.mongo.controller;

import com.qianhua.mongo.pojo.Comment;
import com.qianhua.mongo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author: Watermelon
 * @Date: 2021/4/7 11:41
 */
@RestController
@RequestMapping("admin")
//@Api(tags = "mongodb测试接口")
public class CommentController {

    public static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;


    @PostMapping("add")
    @ApiOperation(value = "新增评论",notes = "新增评论",produces = "application/json")
    public String saveComment(@RequestBody Comment comment){
        commentService.saveComment(comment);
        return "ok";
    }
}
