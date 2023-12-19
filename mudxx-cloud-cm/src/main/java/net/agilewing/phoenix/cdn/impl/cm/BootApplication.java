package net.agilewing.phoenix.cdn.impl.cm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author laiw
 * @date 2023/4/3 11:45
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
