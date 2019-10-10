package com.lallu.lal.controller;


import com.lallu.lal.service.GetResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
public class GetResultController {

  @Autowired
  GetResultService getResultService;

  @GetMapping(value="/v1/getResultService")
  @ResponseStatus(HttpStatus.OK)
  Mono<String> getResult(){
      return getResultService.httpsCall();
  }

}
