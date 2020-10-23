package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Date;

public class GreeterService {
    public GreeterService() {
        System.out.println("GreetingService is being created when time is" + new Date());
    }
    String sayHi() {
        return "hello world";
    }
}
