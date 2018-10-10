package com.team.springboot.myspringboot.commom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultBody errorHandle(HttpServletRequest request, Exception e) {
        log.error("request url: {}", String.valueOf(request.getRequestURL()));
        String message = String.valueOf(e);
        log.error(message);
        e.printStackTrace();
        return ResultBody.error(message);
    }

}
