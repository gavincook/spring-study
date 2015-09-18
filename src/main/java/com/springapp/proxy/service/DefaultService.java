package com.springapp.proxy.service;

import org.springframework.stereotype.Service;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
@Service
public class DefaultService implements BaseService {
    @Override
    public void doThis() {
        System.out.println("default do this");
    }

    @Override
    public void doThat() {
        System.out.println("default do that");
    }
}
