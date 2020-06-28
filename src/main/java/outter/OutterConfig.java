package outter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

public class OutterConfig {

    private static final Logger log = LoggerFactory.getLogger(OutterConfig.class);

    @Bean
    public Outter outter() {
        log.info("Create outter bean");
        return new Outter();
    }

    @Bean
    private Other other() {
        log.info("Create other bean");
        return new Other();
    }
}
