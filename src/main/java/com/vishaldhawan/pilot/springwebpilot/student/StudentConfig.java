package com.vishaldhawan.pilot.springwebpilot.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
          Student s1 = new Student("Adam", "adam@gmail.com", LocalDate.of(2004, 10, 20));
          Student s2 = new Student("Brian", "brian@gmail.com", LocalDate.of(1996, 9, 15));

          studentRepository.saveAll(List.of(s1, s2));
        };
    }

}
