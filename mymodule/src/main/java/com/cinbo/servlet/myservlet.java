package com.cinbo.servlet;

import com.cinbo.iface.WebProcess;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/6/18 9:47
 */
public class myservlet extends HttpServlet {

    public WebProcess myWebProcess;
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

            resp.getOutputStream().write(((String)myWebProcess.process("insert1")).getBytes());

    }

    @Override
    public void init(){
//        Object config = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext())
//                .getBean("dataSourceHikari", HikariDataSource.class);
        myWebProcess = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext())
                .getBean("myWebProcess",WebProcess.class);

    }


}
