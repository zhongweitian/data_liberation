package com.zwt.data_liberation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DataLiberationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataLiberationApplication.class, args);
    }

}
