package com.user.servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 扣1
public class ThymeleafServlet extends HttpServlet {

    private TemplateEngine templateEngine;
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        // 创建视图解析器
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        // 设置参数
        templateResolver.setTemplateMode(TemplateMode.HTML);
        //设置前缀
        String prefix = servletContext.getInitParameter("view-prefix");
        templateResolver.setPrefix(prefix);
        // 设置后缀
        String suffix = servletContext.getInitParameter("view-suffix");
        templateResolver.setSuffix(suffix);
        // 前缀 + 视图名称 + 后缀
        // 缓存时间
        templateResolver.setCacheTTLMs(60000L);
        // 是否缓存
        templateResolver.setCacheable(true);
        // 编码方式
        templateResolver.setCharacterEncoding("utf-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    protected void processTemplate(String templateName, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws IOException {
        // 设置响应字符集
       httpResponse.setContentType("text/html;charset=UTF-8");
       WebContext webContext = new WebContext(httpRequest, httpResponse, getServletContext());
       templateEngine.process(templateName,webContext,httpResponse.getWriter());
    }


}
