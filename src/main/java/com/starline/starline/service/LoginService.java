package com.starline.starline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starline.starline.repository.LoginRespository;
import com.starline.starline.entity.Login;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private LoginRespository loginRepository;

    public List<Login> test() //회원가입
    {
        return loginRepository.findAll();
    }
}
