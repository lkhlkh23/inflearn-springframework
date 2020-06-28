package inflearn.spring.spring;

import inflearn.spring.spring.config.ApplicationConfig;
import inflearn.spring.spring.domain.Book;
import inflearn.spring.spring.repository.BookRepository;
import inflearn.spring.spring.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import outter.Outter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);

		// componenet scan은 초기 구동 시, bean을 등록하기 때문에 구동시간이 길어지는 문제

		// proxy, reflection 은 성능의 영향을 주지만 functional bean 등록은 성능상의 (구동 시간) 문제가 적다
		new SpringApplicationBuilder().sources(Application.class)
									  .initializers((ApplicationContextInitializer<GenericApplicationContext>) context -> {
									  	context.registerBean(Outter.class);
									  })
									  .run(args);
	}

	private static void initBeanByAnnotationScan() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

	private static void initBeanByScan() {
		/* 어노테이션 기반의 스캐닝 방식 */
		ApplicationContext context = new ClassPathXmlApplicationContext("application2.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.save(new Book());
	}

	private static void initBeanByRegisteringBean() {
		/* 빈등록이 번거롭고 어렵다 */
		ApplicationContext context = new ClassPathXmlApplicationContext("application1.xml");
		BookService bookService = (BookService) context.getBean("bookService");
		bookService.save(new Book());
	}

}
