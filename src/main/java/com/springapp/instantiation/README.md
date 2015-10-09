### Instantiating beans(初始化Bean)

* 直接使用构造方法构造，可指定构造参数来指定使用有参的构造函数

* 使用静态的工厂方法构造，`<bean>`标签的`factory-method`属性可以指定要使用的工厂方法来获取指定类型的bean

* 使用其他实例的工厂方法构造，使用`<bean>`的`factory-bean`指定具体需要使用的实例，`factory-method`来指定需要调用该实例的工厂方法

* [延迟初始化](https://github.com/gavincook/spring-study/tree/master/src/main/java/com/springapp/instantiation/lazy)
