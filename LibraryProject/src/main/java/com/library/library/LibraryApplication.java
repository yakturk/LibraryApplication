package com.library.library;

import com.library.library.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
main spring boot class to run the application
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.library.library"})
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}

