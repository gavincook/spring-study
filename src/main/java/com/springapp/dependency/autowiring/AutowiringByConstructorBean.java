package com.springapp.dependency.autowiring;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class AutowiringByConstructorBean {

    private ConstructorArgOne constructorArgOne;

    public AutowiringByConstructorBean(ConstructorArgOne constructorArgOne){
        this.constructorArgOne = constructorArgOne;
    }

    public ConstructorArgOne getConstructorArgOne() {
        return constructorArgOne;
    }
}
