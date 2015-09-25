package com.springapp.dependency;

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
@ContextConfiguration("classpath:bean-dependency.xml")
public class BeanDependencyTest {

    @Autowired
    protected ApplicationContext ac;

    @Test
    public void beanDependencyTest(){
        ExampleThree exampleThree = ac.getBean("exampleThree",ExampleThree.class);
        Assert.isTrue("first".equals(exampleThree.getArg1()));
        Assert.isTrue("second".equals(exampleThree.getArg2()));

        /**
         * {@link ExampleFour} and {@link ExampleFive} is Circular dependency each other in setter way
         */
        ExampleFour exampleFour = ac.getBean("exampleFour",ExampleFour.class);
        ExampleFive exampleFive = ac.getBean("exampleFive",ExampleFive.class);
        Assert.isTrue(exampleFour.getExampleFive() == exampleFive);
        Assert.isTrue(exampleFive.getExampleFour() == exampleFour);
    }

    @Test
    public void collectionDependencyTest(){
        CollectionDependency collectionDependency = ac.getBean("collectionDependency",CollectionDependency.class);
        Assert.isTrue(collectionDependency.getList().size() == 3);
        Assert.isTrue(collectionDependency.getProperties().size() == 3);
        Assert.isTrue(collectionDependency.getSet().size() == 3);
        Assert.isTrue(collectionDependency.getMap().size() == 3);

        CollectionDependency collectionDependency1 = ac.getBean("collectionDependencyChild",CollectionDependency.class);
        Assert.isTrue(collectionDependency1.getProperties().size() == 4);
    }
}
