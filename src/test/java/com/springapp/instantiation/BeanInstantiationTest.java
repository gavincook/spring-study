package com.springapp.instantiation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-instantiation.xml")
public class BeanInstantiationTest {

    @Autowired
    protected ApplicationContext ac;

    @Test
    public void beanInstantiationTest(){
        Assert.notNull(ac.getBean("constructibleBean"));
        Assert.notNull(ac.getBean("staticFactoryBean"));
        Assert.notNull(ac.getBean("factoryBean"));
    }
}
