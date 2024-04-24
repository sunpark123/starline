package com.starline.starline.controller;

import com.starline.starline.entity.Login;
import com.starline.starline.entity.Post;
import com.starline.starline.entity.user_info;
import com.starline.starline.entity.Comment;
import com.starline.starline.service.CommentService;
import com.starline.starline.service.user_infoService;
import com.starline.starline.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.starline.starline.service.LoginService;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Controller
@SessionAttributes("userMail")
public class LoginController {
    @Autowired
    public LoginService loginService;
    @Autowired
    public user_infoService userInfoService;
    @Autowired
    public PostService postService;
    @Autowired
    public CommentService commentService;

    private String Paths="";

    @PostMapping("/registers")
    public String registers(Login info, HttpSession session){
        var r = "home";
        if(loginService.registers(info) == true)
        {
            System.out.println("already have ");
        }
        else{
            r = "makeuser";
            session.setAttribute("userMail", info.getMail());
            System.out.println("good");
        }
        return "redirect:/"+r;
    }

    @GetMapping("/login")
    public String login(HttpSession session){
        String r = "login.html";
        String userMail = (String) session.getAttribute("userMail");
        if(userMail != null)
        {
            r = "redirect:/home";
        }

        return r;
    }
    @GetMapping("/makeuser")
    public String makeuser(HttpSession session){
        String r = "redirect:/home";
        String userMail = (String) session.getAttribute("userMail");
        if(userMail != null)
        {
            r = "make_pfp.html";

        }
        return r;
    }
    @PostMapping("/logins")
    public String logins(Login info, HttpSession session){
        String r = "redirect:/login";
        if(loginService.login(info) == true)
        {
            session.setAttribute("userMail", info.getMail());
            r = "redirect:/home";
        }

        return r;
    }
    @GetMapping("home")
    public String main(Model model, HttpSession session){
        String r = "redirect:/login";
        String userMail = (String) session.getAttribute("userMail");
        Post post =  postService.get_randomPost();
        if(userMail!=null)
        {
            model.addAttribute("post",post);
            model.addAttribute("comments",commentService.getAllCommentOfId(post.getId()));
            model.addAttribute("UserId",userInfoService.getUserIdOfMail(userMail));
            model.addAttribute("UserPfpLoc",userInfoService.getUserPfpLocationOfMail(userMail));
            r = "post.html";
        }

        return r;
    }
    @GetMapping("file")
    public String test(){
        return "fileuploadtest.html";
    }



    @PostMapping("/check_userid")
    @ResponseBody
    public String submit_username(@RequestBody String username) {

        String data = userInfoService.userid_search(username);
        return data;
    }
    @PostMapping("/pfp_upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            if(Objects.equals(StringUtils.getFilenameExtension(file.getOriginalFilename()), "jpg") || Objects.equals(StringUtils.getFilenameExtension(file.getOriginalFilename()), "png")  || Objects.equals(StringUtils.getFilenameExtension(file.getOriginalFilename()), "jpeg"))
            {
                String loc = "C:/Users/user/Desktop/starline/src/main/resources/static/starline_file/pfp/"+file.getOriginalFilename();
                Paths = file.getOriginalFilename();
                file.transferTo(new File(loc));
            }
        }

        return "redirect:/home";
    }
    @PostMapping("/pfp_post")
    public String pfp_post(@RequestBody user_info user_info,HttpSession session){
        String userMail = (String) session.getAttribute("userMail");

        if(userMail!=null)
        {
            userInfoService.pfp_save(user_info,Paths);
        }

        return "redirect:/home";
    }

    @PostMapping("/add_comment")
    public String addcomment(@RequestBody Comment comment ,HttpSession session){
        String userMail = (String) session.getAttribute("userMail");
        commentService.addComment(comment, userMail);
        System.out.println(comment);
        return "redirect:/home";
    }
}
