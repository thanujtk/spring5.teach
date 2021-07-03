package org.tk.spring.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * At high level.
 *
 * <ol>
 *    1. Instantiate the bean
 *    2. Populate properties
 *    3. Bean Name Aware
 *    4. Bean classloader Aware
 *    5. Bean Factory Aware
 *    6. Environment Aware
 *    7. EmbeddedValue Resolver Aware
 *    8. Resource Loader Aware
 *    9. ApplicationEvent Publisher Aware
 *    10. MessageSource Aware
 *    11. ApplicationContext Aware
 *    12. ServletContext Aware
 *    13. Pre-Initialization BeanPostProcessor
 *    14. Custom init-method
 *    15. InitializingBean afterPropertiesSet
 *    16. Post-Initialization BeanPostProcessor
 *    17. DisposableBean.destroy
 * </ol>
 */
public class MainBeanLifeCycle {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);

        //List all the beans,
        Arrays.stream(annotationConfigApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);

        annotationConfigApplicationContext.close();
    }
}

