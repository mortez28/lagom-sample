package com.example.qcri.my_system.servicea.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

/**
 * The ServiceA service interface.
 * <p>
 * This describes everything that Lagom needs to know about how to serve and
 * consume the ServiceA.
 */
public interface ServiceAService extends Service {


  ServiceCall<NotUsed, Long> sum();

  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("servicea").withCalls(
        pathCall("/api/service/a/sum",  this::sum)
      ).withAutoAcl(true);
    // @formatter:on
  }
}
