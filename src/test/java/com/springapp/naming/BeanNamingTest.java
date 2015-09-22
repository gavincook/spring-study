package com.springapp.naming;

import com.springapp.SimpleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-naming.xml")
public class BeanNamingTest {

    @Autowired
    protected ApplicationContext ac;

    @Test
    public void beanAliasesTest(){
        String[] beanNames = ac.getAliases("simpleBean");
        System.out.println("total aliases count:"+beanNames.length);
        System.out.println("aliases details:"+Arrays.toString(beanNames));
    }
}
