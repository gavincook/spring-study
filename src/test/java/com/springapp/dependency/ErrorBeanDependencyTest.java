package com.springapp.dependency;

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
@ContextConfiguration("classpath:error-bean-dependency.xml")
public class ErrorBeanDependencyTest {

    @Autowired
    protected ApplicationContext ac;

    /**
     * {@link ExampleOne} and {@link ExampleTwo} depend on each other in constructor, this case it would throw an error,
     * to resolve the Circular dependencies, can make the dependency into setter way. see {@link BeanDependencyTest}
     */
    @Test
    public void errorBeanDependencyTest(){

    }
}
