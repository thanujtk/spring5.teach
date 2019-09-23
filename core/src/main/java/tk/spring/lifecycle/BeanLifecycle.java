package tk.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * As defined in  {@link org.springframework.beans.factory.BeanFactory}
 * https://www.tutorialspoint.com/spring/spring_ioc_containers.htm
 */
@Component
public class BeanLifecycle implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware,
        MessageSourceAware, ApplicationContextAware, BeanPostProcessor {

    @Override
    public void setBeanName(String s) {
        System.out.println("1: BeanNameAware :=" + s);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("2: BeanClassLoaderAware :=" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3: BeanFactoryAware :=" + beanFactory);
    }


    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("4: EnvironmentAware :=" + environment);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("5: EmbeddedValueResolverAware :=" + stringValueResolver);
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("6: ResourceLoaderAware :=" + resourceLoader);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("7: ApplicationEventPublisherAware :=" + applicationEventPublisher);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("8: MessageSourceAware :=" + messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("9: ApplicationContextAware :=" + applicationContext);
        System.out.println("10: ServletContextAware := Applicable only in web environment");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("11: BeanPostProcessor.postProcessBeforeInitialization :=[" + beanName + "] = " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("11: BeanPostProcessor.postProcessAfterInitialization :=[" + beanName + "] = " + bean);
        return bean;
    }


}
