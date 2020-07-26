package cg.wbd.grandemonstration;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }
}
