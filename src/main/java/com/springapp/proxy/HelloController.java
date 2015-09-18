package com.springapp.proxy;

import com.springapp.proxy.advice.DebugInterceptor;
import com.springapp.proxy.service.BaseService;
import com.springapp.proxy.service.DefaultService;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    public static void main(String[] args) {
        BaseService service = new DefaultService();
        ProxyFactory factory = new ProxyFactory(service);
        factory.setProxyTargetClass(true);

        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*do.*");
        PointcutAdvisor advisor = new DefaultPointcutAdvisor(pointcut , new DebugInterceptor());

        factory.addAdvisor(advisor);
        DefaultService serviceProxy = (DefaultService) factory.getProxy();
        serviceProxy.doThis();
    }
}