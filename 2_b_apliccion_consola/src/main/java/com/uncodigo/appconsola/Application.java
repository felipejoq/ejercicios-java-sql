package com.uncodigo.appconsola;

import com.uncodigo.appconsola.controller.MenuOpcionesController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private MenuOpcionesController menuOpcionesController;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        menuOpcionesController.mostrarMenu();
    }
}
