package com.example.qcri.my_system.servicec.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;


public interface ServiceCService extends Service {


  ServiceCall<NotUsed, Integer> get();

  @Override
  default Descriptor descriptor() {
    return named("c").withCalls(
        pathCall("/api/service/c/get",  this::get)
      ).withAutoAcl(true);
  }
}
