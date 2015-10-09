### 自动注入

* byName: 依照setter方法的参数名，来寻找对应的bean定义，然后完成属性注入。如[AutowiringByNameBean](https://github.com/gavincook/spring-study/tree/master/src/main/java/com/springapp/dependency/autowiring/AutowiringByNameBean.java)中的属性`propertyOne`就会通过方法`setPropertyOne`来注入。

* byType: 依照setter方法的参数的类型，来寻找对应的bean定义，然后完成属性注入。如[AutowiringByTypeBean](https://github.com/gavincook/spring-study/tree/master/src/main/java/com/springapp/dependency/autowiring/AutowiringByTypeBean.java)中的属性`propertyOne`就会通过方法`setPropertyOne`来注入。依据类型注入时，如果有多个相同的类型的bean定义，则会抛出异常。比如这里，如果我们把`PropertyTwo`也配置到spring容器中，则`setProperty`方法注入`property`属性时会抛出异常，因为`Property`类型有两个bean定义：`propertyOne`和`propertyTwo`.

* constructor: 根据构造函数的参数，来寻找对应的bean定义，然后完成属性注入。该方式和`byType`方式一样，按照类型来寻找bean定义，唯一不同的是：处理的是构造参数。如[AutowiringByConstructorBean](https://github.com/gavincook/spring-study/tree/master/src/main/java/com/springapp/dependency/autowiring/AutowiringByConstructorBean.java)中的构造参数`constructorArgOne`就会通过构造方法来注入

#### 自动注入的限制或不足

* 不能处理基础类型、`String`以及`Class`这几种类型

* 没有明确指定依赖准确，Spring会根据自动注入策略进行最佳的猜测


### 解决多个同类型候选Bean定义的自动注入

* 使用`primary`可以标识在多个同类型的bean定义中，使用哪一个bean定义。将需要进行自动注入匹配的设置为`primary="true"`即可，默认为`false`

* 使用`autowire-candidate`属性可将具体的bean定义排除在自动注入的选择范围之外。将不需要参与自动注入的bean设置为`autowire-candidate="false"`即可，默认为`true`.
