package com.cinbo.servlet;

import com.cinbo.iface.WebProcess;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyinbo
 * @version 1.0
 * @date 2020/6/18 9:47
 */
public class myservlet extends HttpServlet {

    public WebProcess myWebProcess;

    private ThreadLocal<List<String>> listString;
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String url = req.getRequestURI();
        List<String> tmpListString = listString.get();
        System.out.println(Thread.currentThread().getName()+": list addr:"+tmpListString.size());
        tmpListString.add("1");
        String outStr="";
        if(url.contains("/insert")) {
            //插入一条记录
            outStr = (String) myWebProcess.process("insert");
        }else{
            //检查id为81的user信息
            outStr = (String) myWebProcess.process("81");
        }
        resp.getOutputStream().write(outStr.getBytes());

    }

    @Override
    public void init(){
//        Object config = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext())
//                .getBean("dataSourceHikari", HikariDataSource.class);
        myWebProcess = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext())
                .getBean("myWebProcess",WebProcess.class);
        listString = ThreadLocal.withInitial(() -> new ArrayList<>(16));
    }


}
