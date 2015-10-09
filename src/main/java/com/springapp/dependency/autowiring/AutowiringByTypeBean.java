package com.springapp.dependency.autowiring;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class AutowiringByTypeBean {

    private PropertyOne propertyOne;

    private PropertyTwo propertyTwo;

    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

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
