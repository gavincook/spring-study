package com.springapp.instantiation.lazy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:lazy.xml")
public class LazyTest {

    @Autowired
    protected ApplicationContext ac;

    @Test
    public void lazyInstantiationTest(){
        System.out.println("Spring Container already initialized");
        //when we try to get the lazy initialized bean first time, spring will init it
        ac.getBean("lazyBean");
    }
}
