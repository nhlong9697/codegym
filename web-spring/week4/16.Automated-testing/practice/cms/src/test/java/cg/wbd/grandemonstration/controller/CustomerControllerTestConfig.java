package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.ProvinceService;
import cg.wbd.grandemonstration.service.impl.CustomerServiceImplWithSpringData;
import cg.wbd.grandemonstration.service.impl.ProvinceServiceImplWithSpringData;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cg.wbd.grandemonstration")
public class CustomerControllerTestConfig {
    @Bean
    public CustomerService customerService() {
        return Mockito.mock(CustomerServiceImplWithSpringData.class);
    }
    @Bean
    public ProvinceService provinceService() {
        return Mockito.mock(ProvinceServiceImplWithSpringData.class);
    }
}
