Spring 4支持Groovy DSL来配置Bean,一种和XML风格配置类似，但比XML语法更加简明。主要使用`GroovyBeanDefinitionReader`解析Groovy DSL配置。
本示例中`AppConfig.groovy`作为Spring Bean配置,其中定义了类型为`TestComponent`的Bean。为了测试,这里还进行了Bean获取和对应方法调用。