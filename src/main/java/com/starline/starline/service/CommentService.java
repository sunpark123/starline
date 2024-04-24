package com.starline.starline.service;

import com.starline.starline.entity.Comment;
import com.starline.starline.repository.CommentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CommentService {
    @Autowired
    private CommentRespository commentRespository;
    @Autowired
    private user_infoService userInfoService;
    public Comment addComment(Comment comment, String mail) {
        comment.setName(userInfoService.getUserIdOfMail(mail));
        comment.setUser_pfploc(userInfoService.getUserPfpLocationOfMail(mail));
        return commentRespository.save(comment);
    }
    public List<Comment> getAllCommentOfId(Integer id)
    {
        List<Comment> comment_list = new ArrayList<>();
        for(Comment comment : commentRespository.findAll()){
            if(Objects.equals(comment.getParent_id(), id.toString())){
                comment_list.add(comment);
            }
        }

        return comment_list;
    }
}
