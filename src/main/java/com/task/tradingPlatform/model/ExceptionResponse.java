package com.task.tradingPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
          private Integer statusCode;
          private String message;
}
