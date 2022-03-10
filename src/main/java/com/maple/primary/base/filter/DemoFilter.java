package com.maple.primary.base.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

// 使用 @WebFilter 方式注册Filter
// 启动类需要增加 @ServletComponentScan

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/3/10-15:10
 * @since 1.8
 */
@Slf4j
@Order(1)
@WebFilter(initParams = {@WebInitParam(name = "demoFilter", value = "/user/login,/user")})
public class DemoFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // Do Something 用于初始化过滤器, 可获取Filter中的初始化参数
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    // Do Something 可修改 Request
    chain.doFilter(req, res);
    // Do Something 可修改 Response
  }

  @Override
  public void destroy() {
    // Do Something 仅执行一次, 服务器停止时执行, 可用于释放Filter占用的资源
  }
}
