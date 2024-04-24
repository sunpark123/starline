package com.starline.starline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.starline.starline.repository.LoginRespository;
import com.starline.starline.entity.Login;
;

@Service
public class LoginService {
    @Autowired
    private LoginRespository loginRepository;
    private BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
    public String user_mail = "";
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
            info.setPassword(bc.encode(info.getPassword()));
            loginRepository.save(info);
            user_mail = info.getMail();
        }
        return already_account;
    }

    public boolean login(Login info) //로그인
    {
        var logins = false;
        for (Login e : loginRepository.findAll()) {
            if (e.getMail().equals(info.getMail())) {
                user_mail=info.getMail();
                if (bc.matches(info.getPassword(), e.getPassword())) {
                    logins = true;
                }
            }
        }

        return logins;
    }

}
