package com.maple.primary.base.aop;

import com.maple.primary.base.exception.AuthException;
import com.maple.primary.base.utils.result.Result;
import com.maple.primary.base.utils.result.ResultBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

  /** RequestParam 参数缺失 */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public Result missParameterException(
      HttpServletRequest request, MissingServletRequestParameterException e) {
    e.printStackTrace();
    String data = "入参 " + e.getParameterType() + " " + e.getParameterName() + " 不可为空";
    return ResultBuilder.exception(403, "参数有误", data);
  }

  /** url_params | path_params 参数类型转换失败 */
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public Result argumentTypeMismatchException(
      HttpServletRequest request, MethodArgumentTypeMismatchException e) {
    e.printStackTrace();
    String data =
        "将入参 "
            + e.getName()
            + " = "
            + e.getValue()
            + " 转换为 "
            + e.getRequiredType().getSimpleName()
            + " 失败";
    return ResultBuilder.exception(403, "参数有误", data);
  }

  /** 其他异常 */
  @ExceptionHandler(Exception.class)
  public Result exception(Exception e) {
    e.printStackTrace();
    return ResultBuilder.exception(500, e.getMessage());
  }

  // TODO 数据库异常
}
