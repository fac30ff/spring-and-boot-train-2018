package ru.exam.examinator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExamResult {
  int                  price;
  int                  result;
  Map<String, Integer> results;
}
