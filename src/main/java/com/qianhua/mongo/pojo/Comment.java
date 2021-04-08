package com.qianhua.mongo.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: Watermelon
 * @Date: 2021/4/7 10:01
 */
//若添加@Document注解，则save到comment集合
@Document(collection = "comment")//可以省略，如果省略，则默认使用类名小写映射集合
//复合索引1标识升序，-1标识倒序
@CompoundIndex(def = "{'userid':1,'nickname':-1}")
@Data
public class Comment {
    //主键标识，改属性的值会自动对应mongodb的主键字段“_id”，如果改属性名就叫“id”，则该注解可以省略，否则必须写
//    @Id
    private String id;//主键

    //该注解对应mongodb的字段名字，如果一致，则无需该注解
    @Field("content")
    private String content;//吐槽内容

    private Date publishtime;//发布日期
    //添加了一个单字段索引
    @Indexed
    private String userid;//发布人id

    private String nickname;//昵称

    private LocalDateTime createdatetime;//评论的日期时间

    private Integer likenum;//点赞数

    private Integer replynum;//回复数

    private String state;//状态

    private String parentid;//上级id

    private String articleid;//文章id

    private List<String> likename;

}
