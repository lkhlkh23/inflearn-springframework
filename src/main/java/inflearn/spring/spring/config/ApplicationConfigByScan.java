package inflearn.spring.spring.config;

import inflearn.spring.spring.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
/*
    basePackages : Type safety 하지 못함
    basePackageClasses : Type safety, Application.class 이하에 있는 클래스와 패키지들을 모두 스캐닝함
*/
public class ApplicationConfigByScan {
}
