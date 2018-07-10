package org.quickstart.modular.jarslink.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
public class ModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ModuleApplication.class, args);
    }
}
