package com.starline.starline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.starline.starline.repository.LoginRespository;
import com.starline.starline.entity.Login;
import java.util.List;
import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    private LoginRespository loginRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean registers(Login info) //회원가입
    {

        var already_account=false;
        for (Login e : loginRepository.findAll()) {
            if (e.getMail().equals(info.getMail())) {
                already_account = true;
            }
        }
        if(!already_account)
        {
            //String encodePassword = passwordEncoder.encode(info.getPassword());
            //info.setPassword(encodePassword);
            loginRepository.save(info);
        }
        return already_account;
    }

    public boolean login(Login info) //로그인
    {
        var logins = false;
        for (Login e : loginRepository.findAll()) {
            if (e.getMail().equals(info.getMail())) {
                if (e.getPassword().equals(info.getPassword())) {
                    logins = true;
                }
            }
        }

        return logins;
    }
}
