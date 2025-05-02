package com.example.egovframesample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.egovframesample.mapper")
public class EgovframeSampleApplication  {
    // extends SpringBootServletInitializer 는 war일 때
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(EgovframeSampleApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(EgovframeSampleApplication.class, args);
    }

}
