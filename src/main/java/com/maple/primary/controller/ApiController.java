package com.maple.primary.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/25-15:44
 * @since 1.8
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
  @Autowired WebApplicationContext applicationContext;

  @GetMapping("/all")
  public List apis() {
    RequestMappingHandlerMapping mapping =
        applicationContext.getBean(RequestMappingHandlerMapping.class);
    // 获取url与类和方法的对应信息
    Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
      Map<String, String> map1 = new HashMap<String, String>();
      RequestMappingInfo info = m.getKey();
      HandlerMethod method = m.getValue();
      PatternsRequestCondition p = info.getPatternsCondition();
      for (String url : p.getPatterns()) {
        map1.put("url", url);
      }
      map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
      map1.put("method", method.getMethod().getName()); // 方法名
      RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
      for (RequestMethod requestMethod : methodsCondition.getMethods()) {
        map1.put("type", requestMethod.toString());
      }

      list.add(map1);
    }
    return list;
  }
}
