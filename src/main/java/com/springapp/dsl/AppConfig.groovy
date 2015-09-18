package com.springapp.dsl

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.context.support.GenericApplicationContext

def ctx = new GenericApplicationContext();
def reader = new GroovyBeanDefinitionReader(ctx)
reader.beans {
    testComponent(TestComponent)
}

ctx.refresh();

//invoke bean method
ctx.getBean("testComponent").test()