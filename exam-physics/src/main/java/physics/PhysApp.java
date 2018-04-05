package physics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class PhysApp {
  public static void main(String[] args) {
    SpringApplication.run(PhysApp.class, args);
  }

  @RestController("/exam")
  public static class ExaminatorController {

    @RequestMapping
    public Exam exam(@RequestParam String id) {
      return Exam.builder()
          .examname("phys")
          .result(new Random(5).nextInt())
          .build();
    }

  }

  @Data
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Exam {
    private String examname;
    private int    result;
  }
}
