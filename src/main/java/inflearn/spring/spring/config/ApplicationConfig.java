package inflearn.spring.spring.config;

import inflearn.spring.spring.repository.BookRepository;
import inflearn.spring.spring.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

}
