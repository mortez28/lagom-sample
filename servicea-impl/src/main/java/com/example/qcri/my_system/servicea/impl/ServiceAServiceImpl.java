package com.example.qcri.my_system.servicea.impl;

import javax.inject.Inject;

import com.example.qcri.my_system.servicea.api.ServiceAService;
import com.example.qcri.my_system.serviceb.api.ServiceBService;
import com.example.qcri.my_system.servicec.api.ServiceCService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import akka.NotUsed;

public class ServiceAServiceImpl implements ServiceAService {


	
	  private final ServiceBService serviceB;
	  private final ServiceCService serviceC;

	  @Inject
	  public ServiceAServiceImpl(ServiceBService serviceB, ServiceCService serviceC) {
	      this.serviceB = serviceB;
	      this.serviceC = serviceC;
	  }

	@Override
	public ServiceCall<NotUsed, Long> sum() {
		return msg -> {
            return serviceB.getpow().invoke(NotUsed.getInstance())
            		.thenCombine(serviceC.get().invoke(NotUsed.getInstance()), (a,b) -> (a+b));
        };
	}
  
}
