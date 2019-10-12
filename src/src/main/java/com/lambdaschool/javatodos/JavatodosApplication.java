package com.lambdaschool.javatodos;


//THIS PAGE IS DONE
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavatodosApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(JavatodosApplication.class,
                args);

    }
}