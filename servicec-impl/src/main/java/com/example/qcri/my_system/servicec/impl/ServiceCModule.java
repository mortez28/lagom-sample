package com.example.qcri.my_system.servicec.impl;

import com.example.qcri.my_system.servicec.api.ServiceCService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the ServiceAService so that it can be served.
 */
public class ServiceCModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindService(ServiceCService.class, ServiceCServiceImpl.class);
  }
}
