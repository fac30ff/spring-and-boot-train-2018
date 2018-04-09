package ru.exam.examinator;

import lombok.*;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
  int                  price;
  @Singular
  Map<String, Integer> results;
}
