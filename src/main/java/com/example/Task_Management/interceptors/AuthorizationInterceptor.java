package com.example.Task_Management.interceptors;

import com.example.Task_Management.Utilities.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        System.out.println("Requested URL: "+ request.getRequestURL());

//        Iterator<String> headerIter = request.getHeaderNames().asIterator();
//        while (headerIter.hasNext()){
//            String HeaderName = headerIter.next();
//            System.out.println("HeaderName: "+ HeaderName+", HeaderValue: "+ request.getHeader(HeaderName));
//        }

        if(token!=null) {
            String[] chunks = token.split(" ", 2);
            System.out.println("Token: " + chunks[1]);

            return (!chunks[1].isEmpty() && jwtTokenUtil.isValidToken(chunks[1]));
        }else{
            response.sendError(200,"Forbidden Access");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //System.out.println(response.getHeaderNames());
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
