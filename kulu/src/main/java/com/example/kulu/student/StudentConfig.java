package com.example.kulu.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.OCTOBER;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository)
    {
        return args -> {
             Student kulamani = new Student("kulamani", "km99pradhan@gmail.com",
                    LocalDate.of(2000, OCTOBER, 18));
            Student punam = new Student( "punam", "punam99pradhan@gmail.com",
                    LocalDate.of(2004, OCTOBER, 18));
            Student Silu = new Student( "silu", "silu@gmail.com",
                    LocalDate.of(1996, OCTOBER, 18));
            repository.saveAll(List.of(kulamani,punam,Silu));

        };
    }
}
