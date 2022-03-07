package com.maple.primary.base.aop;

import com.maple.primary.base.exception.AuthException;
import com.maple.primary.base.utils.result.Result;
import com.maple.primary.base.utils.result.ResultBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qifeng.b.chen
 * @version 1.0
 * @date 2022/1/24-11:49
 * @since 1.8
 */
@RestControllerAdvice
public class ControllerGlobalHandler {
  /** 权限异常 */
  @ExceptionHandler(AuthException.class)
  public Result authException(HttpServletRequest request, AuthException e) {
    e.printStackTrace();
    String message = StringUtils.isBlank(e.getMessage()) ? "登录信息有误，请登录后重试" : e.getMessage();
    return ResultBuilder.exception(401, message);
  }
  /** 针对Validate校验异常 */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result methodArgumentNotValidException(
      HttpServletRequest request, MethodArgumentNotValidException e) {
    e.printStackTrace();
    return ResultBuilder.exception(403, "参数有误", e.getBindingResult());
  }

  /** 其他异常 */
  @ExceptionHandler(Exception.class)
  public Result exception(Exception e) {
    e.printStackTrace();
    return ResultBuilder.exception(500, e.getMessage());
  }

  // TODO 数据库异常
}
