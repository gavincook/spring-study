
### Spring Bean naming(Spring Bean 命名)

在XML配置风格中，可以使用`bean`标签的`id`或者`name`指定bean名称。其中`id`允许指定一个唯一的标示，而`name`属性可以指定多个名称，可以使用`,`,`;`或空格分隔。 有如下几种情况：

* 当即没有`id`，也没有`name`属性时，Spring 使用类型加序号作为bean的名称，比如这里的`SimpleBean`，如果不指定`id`和`name`，则它的名称就会形如`com.springapp.SimpleBean#0`

* 当有`id`属性时，bean的名称就为`id`属性的值。此时，如果有`name`属性，则`name`属性的值作为bean的别称

* 当只有`name`属性，无`id`属性时，则会使用`name`属性的第一个名称（可能有多个）作为bean的名称。`name`属性剩下的名称，则为bean的别称


另外，还可以使用`<alias>`标签，在bean定义之外指定bean的别称，其`alias`属性，和`<bean>`标签的`name`属性语法一样，可支持多个名字的配置。

