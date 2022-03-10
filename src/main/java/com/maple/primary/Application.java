package com.maple.primary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.maple.primary.mapper")
@SpringBootApplication
public class Application {
  // https://www.jb51.net/article/213434.htm
  static {
    System.setProperty("druid.mysql.usePingMethod", "false");
  }

  public static void main(String[] args) {

    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
  }
}
