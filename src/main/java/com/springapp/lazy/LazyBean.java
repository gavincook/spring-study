package com.springapp.lazy;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Lazy-initialized bean, this one would not init util it used
 * @author GavinCook
 * @since 1.0.0
 **/
public class LazyBean implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean:["+name+"] initialized");
    }
}
