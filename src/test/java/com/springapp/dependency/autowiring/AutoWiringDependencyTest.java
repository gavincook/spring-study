package com.springapp.dependency.autowiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-autowiring.xml")
public class AutowiringDependencyTest {

    @Autowired
    protected ApplicationContext ac;

    @Test
    public void autowiringByNameTest(){
        PropertyOne propertyOne = ac.getBean("propertyOne",PropertyOne.class);
        AutowiringByNameBean autowiringByNameBean = ac.getBean("autowiringByNameBean",AutowiringByNameBean.class);
        Assert.isTrue(propertyOne == autowiringByNameBean.getPropertyOne());
        Assert.isNull(autowiringByNameBean.getPropertyTwo());
    }

    @Test
    public void autowiringByTypeTest(){
        PropertyOne propertyOne = ac.getBean("propertyOne",PropertyOne.class);
        AutowiringByTypeBean autowiringByTypeBean = ac.getBean("autowiringByTypeBean",AutowiringByTypeBean.class);
        Assert.isTrue(propertyOne == autowiringByTypeBean.getPropertyOne());
    }

    @Test
    public void autowiringByConstructorTest(){
        ConstructorArgOne constructorArgOne = ac.getBean("constructorArgOne",ConstructorArgOne.class);
        AutowiringByConstructorBean autowiringByConstructorBean = ac.getBean("autowiringByConstructorBean",AutowiringByConstructorBean.class);
        Assert.isTrue(constructorArgOne == autowiringByConstructorBean.getConstructorArgOne());
    }
}
