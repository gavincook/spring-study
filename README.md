# spring-study

### [DSL configuration](https://github.com/gavincook/spring-study/tree/master/src/main/java/com/springapp/dsl)

### Spring Bean naming(Spring Bean 命名)

在XML配置风格中，可以使用`bean`标签的`id`或者`name`指定bean名称。其中`id`允许指定一个唯一的标示，而`name`属性可以指定多个名称，可以使用`,`,`;`或空格分隔。 有如下几种情况：

* 当即没有`id`，也没有`name`属性时，Spring 使用类型加序号作为bean的名称，比如这里的`SimpleBean`，如果不指定`id`和`name`，则它的名称就会形如`com.springapp.SimpleBean#0`

* 当有`id`属性时，bean的名称就为`id`属性的值。此时，如果有`name`属性，则`name`属性的值作为bean的别称

* 当只有`name`属性，无`id`属性时，则会使用`name`属性的第一个名称（可能有多个）作为bean的名称。`name`属性剩下的名称，则为bean的别称


另外，还可以使用`<alias>`标签，在bean定义之外指定bean的别称，其`alias`属性，和`<bean>`标签的`name`属性语法一样，可支持多个名字的配置。

### Instantiating beans(初始化Bean)

* 直接使用构造方法构造，可指定构造参数来指定使用有参的构造函数

* 使用静态的工厂方法构造，`<bean>`标签的`factory-method`属性可以指定要使用的工厂方法来获取指定类型的bean

* 使用其他实例的工厂方法构造，使用`<bean>`的`factory-bean`指定具体需要使用的实例，`factory-method`来指定需要调用该实例的工厂方法

### Dependencies(依赖)

#### 1.依赖注入

* 构造函数注入

* setter方法注入

一般来说必要的属性，应当通过构造函数来注入，而可选属性则应当使用setter方法注入。对于循环依赖（A依赖B，且B依赖A），如果是构造函数的循环依赖，Spring会抛出`BeanCurrentlyInCreationException`。解决循环依赖可使用setter方法注入，Spring的处理逻辑为：在bean完全初始化之前，将其中一个bean注入到另外一个bean中，使得循环依赖中的一个bean先完全初始化，然后再将完全初始化的bean注入到另一个循环依赖的bean中。

#### 2.注入数据类型

* 基础类型和字符串

假设属性名称为`name`,需要注入的值为字符串`"zhangsan"`. 可使用`<property name="name" value="zhangsan"/>`或者`<bean p:name="zhangsan"/>`来完成属性注入

* 引用其他bean

假设属性名称为`reference`,需要注入的值为一个名称为`collaborator`的bean. 可以使用：`<property name="reference" ref="collaborator"/>` 或 
```
<property name="reference">
	<idref bean="collaborator"/>
</property>
```
也可以使用`<property name="reference" value="collaborator"/>`，这里`value`所代表的字符串会被处理为其代表的bean。但是此方法的一个问题就是，Spring配置文件无法通过语法检测出配置是否有问题，只有运行期使用的时候才会发现问题。

* 内部bean

Spring允许定义内部bean，内部bean是匿名的，会随着外部bean的创建而创建。内部bean只能注入到外部bean，是不能注入到其他的bean中。其定义形式如下：
```
<bean id="outer" class="...">
    <!-- instead of using a reference to a target bean, simply define the target bean inline -->
    <property name="target">
        <bean class="com.example.Person"> <!-- this is the inner bean -->
            <property name="name" value="Fiona Apple"/>
            <property name="age" value="25"/>
        </bean>
    </property>
</bean>
```

* 集合
 
 Spring支持`List`,`Map`,`Set`和`Properties`几种集合类型，分别用标签`<List>`,`<Map>`,`<Set>`以及`<Properties>`表示。