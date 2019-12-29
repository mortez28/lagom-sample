package com.example.qcri.my_system.servicea.impl;

import com.example.qcri.my_system.servicea.api.ServiceAService;
import com.example.qcri.my_system.serviceb.api.ServiceBService;
import com.example.qcri.my_system.servicec.api.ServiceCService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.client.ServiceClientGuiceSupport;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the ServiceAService so that it can be served.
 */
public class ServiceAModule extends AbstractModule implements ServiceGuiceSupport ,ServiceClientGuiceSupport {
  @Override
  protected void configure() {
    bindService(ServiceAService.class, ServiceAServiceImpl.class);
    bindClient(ServiceCService.class);
    bindClient(ServiceBService.class);
  }
}
