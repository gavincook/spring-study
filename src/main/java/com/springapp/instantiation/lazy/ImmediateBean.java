package com.springapp.instantiation.lazy;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class ImmediateBean implements BeanNameAware{
    @Override
    public void setBeanName(String name) {
        System.out.println("Bean:["+name+"] initialized");
    }
}
