package com.starline.starline.service;

import com.starline.starline.entity.Login;
import com.starline.starline.entity.user_info;
import com.starline.starline.repository.User_infoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class user_infoService {
    @Autowired
    private User_infoRespository userInfoRespository;
    @Autowired
    private LoginService loginService;
    public String userid_search(String user_id) {
        List<user_info> userOptional = userInfoRespository.findAll();
        String r = "no";
        for(user_info e : userOptional)
        {
            if(e.getUser_id().equals(user_id))
            {
                r = "yes";
            }
        }
        return r;
    }
    public String pfp_save(user_info user_info, String path)
    {
        user_info.setMail(loginService.user_mail);
        user_info.setPfp_location(path);
        userInfoRespository.save(user_info);
        return "";
    }
    public String getUserIdOfMail(String mail)
    {
        String Userid = "";
        for(user_info e : userInfoRespository.findAll())
        {
            if(e.getMail().equals(mail))
            {
                Userid = e.getUser_id();
            }
        }
        return Userid;
    }
    public String getUserPfpLocationOfMail(String mail)
    {
        String Userpfploc = "";
        for(user_info e : userInfoRespository.findAll())
        {
            if(e.getMail().equals(mail))
            {
                Userpfploc = e.getPfp_location();
            }
        }
        return Userpfploc;
    }
}
