package org.tk.spring.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.*;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

/**
 * As defined in  {@link org.springframework.beans.factory.BeanFactory}
 * https://www.tutorialspoint.com/spring/spring_ioc_containers.htm
 *<ol>
 * 1. instantiate
 * 2. populate properties
 * 3. BeanNameAware
 * 4. BeanFactoryAware
 * 5. Pre-initialization - BeanPostProcessor
 * 6. InitializeBean
 * 7. init-method
 * 8. Post-initialization - BeanPostProcessor
 * 9. ....
 * </ol>
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class BeanLifecycle implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware,
        MessageSourceAware, ApplicationContextAware, InitializingBean, DisposableBean {

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
    public void afterPropertiesSet() throws Exception {
        System.out.println("12: InitializingBean.afterPropertiesSet ");
    }


    @PostConstruct
    private void customInit() {
        System.out.println("13: Custom init-method as defined @Bean(initMethod = \"customInit\")  or @PostConstruct");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("15: Called DisposableBean.destory method ");
    }
}
