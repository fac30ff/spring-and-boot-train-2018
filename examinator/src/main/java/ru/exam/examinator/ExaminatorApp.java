package ru.exam.examinator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@SpringBootApplication
public class ExaminatorApp {
  public static void main(String[] args) {
    SpringApplication.run(ExaminatorApp.class, args);
  }

  @RequiredArgsConstructor
  @RestController
  @RequestMapping("exam")
  @EnableConfigurationProperties({ExamProperties.class})
  @EnableDiscoveryClient
  public static class ExaminatorController {
    private final RestTemplate    restTemplate;
    private final ExamProperties  examProperties;
    private final DiscoveryClient discoveryClient;

    @RequestMapping
    public List<ConcreteExamResponse> exam(@RequestParam HashMap<String, String> var) {

      return discoveryClient.getServices().stream()
          .map(serviceName -> {
            log.info("Send request to {} ", serviceName);
            var.put("servicename", serviceName);

            if (serviceName.equals("examinator")) {
              return ConcreteExamResponse.builder().build();
            }
            return restTemplate
                .getForEntity("http://{servicename}/exam?id={id}", ConcreteExamResponse.class, var)
                .getBody();

          }).collect(Collectors.toList());

//      examProperties.getTypes().forEach((s, s2) -> {
//
//      });
//
//      ResponseEntity<ConcreteExamResponse> physResults = restTemplate
//          .getForEntity("http://localhost:8081/exam?id=23", ConcreteExamResponse.class, var);
//
//      ResponseEntity<ConcreteExamResponse> mathResults = restTemplate
//          .getForEntity("http://localhost:8082/exam?id=23", ConcreteExamResponse.class, var);

//      ConcreteExamResponse phys = physResults.getBody();
//      ConcreteExamResponse math = mathResults.getBody();

//      return ExamResult.builder()
//          .result(phys.getExamine(), phys.getResult() )
//          .result(math.getExamine(), math.getResult())
//          .build();
    }

  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
    return restTemplateBuilder
        .build();
  }
}
