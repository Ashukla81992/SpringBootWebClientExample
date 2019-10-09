package com.lallu.lal.service;

import com.lallu.lal.downstreamCalls.HttpsDownStreamCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetResultService {

  @Autowired
  HttpsDownStreamCall httpsDownStreamCall;

  public String httpsCall(){

//    return httpsDownStreamCall.httpsCall("https://api.github.com/users/hadley/orgs","GET");
    return httpsDownStreamCall.httpsCall("https://reqres.in/api/users/2","GET");

  }

}
