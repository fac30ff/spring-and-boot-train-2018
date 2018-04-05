package ru.exam.examinator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ExaminatorApp {
  public static void main(String[] args) {
    SpringApplication.run(ExaminatorApp.class, args);
  }

  @RestController
  @RequestMapping("exam")
  public static class ExaminatorController {

    @RequestMapping
    public ExamResult exam(@RequestParam String id) {
      return ExamResult.builder()
          .build();
    }


  }
}
