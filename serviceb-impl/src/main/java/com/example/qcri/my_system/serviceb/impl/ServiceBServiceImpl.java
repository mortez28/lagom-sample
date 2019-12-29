package com.example.qcri.my_system.serviceb.impl;

import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.example.qcri.my_system.serviceb.api.ServiceBService;
import com.example.qcri.my_system.servicec.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;


public class ServiceBServiceImpl implements ServiceBService {

private final ServiceCService serviceC;
	
	@Inject
	  public ServiceBServiceImpl(ServiceCService serviceC) {
	      this.serviceC = serviceC;
	  }
	
	@Override
	public ServiceCall<NotUsed, Long> getpow() {
        return request -> {
        	CompletionStage<Integer> response = serviceC.get().invoke(NotUsed.getInstance());
            return response.thenApply(answer -> (long)answer * (long)answer);
        };
	}

}
