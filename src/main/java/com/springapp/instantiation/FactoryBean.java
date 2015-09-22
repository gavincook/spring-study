package com.springapp.instantiation;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class FactoryBean {

    private String arg;

    FactoryBean(String arg){
        this.arg = arg;
    }

    public static FactoryBean init(){
        return new FactoryBean(FactoryBean.class.getSimpleName());
    }

}
