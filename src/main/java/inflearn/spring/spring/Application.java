package inflearn.spring.spring;

import inflearn.spring.spring.config.ApplicationConfig;
import inflearn.spring.spring.domain.Book;
import inflearn.spring.spring.service.BookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

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
