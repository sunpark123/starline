package com.starline.starline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.starline.starline.repository.LoginRespository;
import com.starline.starline.entity.Login;
import java.util.List;
import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    private LoginRespository loginRepository;

    public String registers(Login info) //회원가입
    {
        var r = "";
        var already_account=false;
        for (Login e : loginRepository.findAll()) {
            if (e.mail.equals(info.mail)) {
                r = "already have account";
                already_account = true;
            }
        }
        if(!already_account)
        {
            loginRepository.save(info);
            r = "make account";
        }
        return r;
    }

    public boolean login(Login info) //로그인
    {
        var logins = false;
        for (Login e : loginRepository.findAll()) {
            if (e.mail.equals(info.mail)) {
                if (e.password.equals(info.password)) {
                    logins = true;
                }
            }
        }

        return logins;
    }
}
