package com.horace.web.core.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-25 23:27
 */
@WebServlet("/") //todo 为何不走 servlet
@Slf4j
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(this.getClass().getSimpleName() + "------>" + "doGet");

        //todo 重要的是这里能做什么
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(this.getClass().getSimpleName() + "------>" + "doPost");
        //todo 重要的是这里能做什么
    }
}
