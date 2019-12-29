package com.example.qcri.my_system.servicec.impl;

import static java.util.concurrent.CompletableFuture.completedFuture;

import javax.inject.Inject;

import com.example.qcri.my_system.servicec.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

/**
 * Implementation of the ServiceAService.
 */
public class ServiceCServiceImpl implements ServiceCService {
	
	@Inject
	  public ServiceCServiceImpl(ServiceCService serviceC) {
	  }
	
	@Override
	public ServiceCall<NotUsed, Integer> get() {
        return request -> {
            return completedFuture(3);
        };
	}


}
