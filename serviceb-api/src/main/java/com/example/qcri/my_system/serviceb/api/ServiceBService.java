package com.example.qcri.my_system.serviceb.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;


public interface ServiceBService extends Service {

  ServiceCall<NotUsed, Long> getpow();

  @Override
  default Descriptor descriptor() {
    return named("b").withCalls(
        pathCall("/api/service/b/getpow",  this::getpow)
      ).withAutoAcl(true);
  }
}
