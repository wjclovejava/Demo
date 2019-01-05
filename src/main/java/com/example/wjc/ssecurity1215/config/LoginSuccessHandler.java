package com.example.wjc.ssecurity1215.config;

import com.example.wjc.ssecurity1215.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: wjc
 * @Description:
 * @Date: created in 2018/12/25 15:10
 */
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
//        response.setContentType("application/json;charset=utf-8");
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("登录用户：username=" + user.getUsername() + ", uri=" + request.getContextPath());
//        ObjectMapper objectMapper = new ObjectMapper();
//        PrintWriter out = response.getWriter();
//        out.write(objectMapper.writeValueAsString(user));
//        out.flush();
//        out.close();
    }
}
