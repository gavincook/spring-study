package com.springapp.dependency.autowiring;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class AutowiringByNameBean {

    private PropertyOne propertyOne;

    private PropertyTwo propertyTwo;

    public PropertyOne getPropertyOne() {
        return propertyOne;
    }

    public void setPropertyOne(PropertyOne propertyOne) {
        this.propertyOne = propertyOne;
    }

    public PropertyTwo getPropertyTwo() {
        return propertyTwo;
    }

    public void setPropertyTwo(PropertyTwo propertyTwo) {
        this.propertyTwo = propertyTwo;
    }
}
