package com.starline.starline.service;

import com.starline.starline.entity.Post;
import com.starline.starline.repository.PostRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PostService {
    @Autowired
    private PostRespository postRespository;

    public Post get_randomPost()
    {
        Integer num = (int) (Math.random() * postRespository.count())+1;
        Optional<Post> rpost = postRespository.findById(num);
        return rpost.get();
    }


}
