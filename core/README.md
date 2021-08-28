__**NOTES**__

1. Java config based spring application doesn't need applicationContext.xml

### Spring core annotations
1. **@Configuration** (class level) - replaces applicationContext.xml. The
   class annotated with @Configuration will have one or more @Bean
   methods. These classes are processed by the Spring container to
   generate bean definitions and service requests for those beans at
   runtime
2. **@Bean** (method level) - Indicates that a method produces a bean to
   be managed by the Spring container. @Bean annotation also can be used
   with parameters like **name**, **initMethod** and **destroyMethod**.
   **@Scope** is used to modify the bean lifecycle.
3. **@PostConstruct** (method level) - alternative way for bean
   initMethod, used when bean class is defined by us.
4. **@PreDestroy** (method level) - alternative way for bean
   destroyMethod, used when bean class is defined by us.
5. **@ComponentScan** (class level) - Configures component scanning
   directives for use with **@Configuration** classes. Here we can specify
   the base packages to scan for spring components. If not specified
   then scan current package and all sub-packages where @Configuration
   class exists.
6. **@Component** (class level) - Indicates that an annotated class is a
   “component”. Such classes are considered as candidates for
   auto-detection when using annotation-based configuration and
   classpath scanning (using @ComponentScan)
7. **@PropertySource** (class level) - provides a simple declarative
   mechanism for adding a property source to Spring’s Environment. There
   is a similar annotation for adding an array of property source files
   i.e **@PropertySources**.
8. **@Service** (class level) - Indicates that an annotated class is a
   “Service”. This annotation serves as a specialization of @Component,
   allowing for implementation classes to be autodetected through
   classpath scanning.
9. **@Respository** (class level) - Indicates that an annotated class is
   a “Repository”. This annotation serves as a specialization of
   @Component and advisable to use with DAO classes.
10. **@Autowired** (instance variable, constructor, method level) - Spring
    @Autowired (by type) annotation is used for automatic injection of
    beans. Spring **@Qualifier** annotation is used in conjunction with
    Autowired to avoid confusion when we have two of more bean
    configured for same type. When Spring can’t find a matching bean to
    wire, it will throw an exception, to fix this set the “**required**”
    attribute of @Autowired to false. 
11. **@Resource** - inject by name
12. **@Qualifier** - Used with @Autowired when more than one bean of
    same type exists in container.
13. **@Required** applies to bean setter method. It indicates that the annotated bean must be populated at configuration time else exception BeanInitilizationException

###Stereotype annotations are
1. **@Component** - class-level annotation, marks a Java class as a spring bean. A Java class annotated with @Component is found during the classpath scan. 
2. **@Service** -  class level annotation, this class contains the business logic.
3. **@Repository** - class level annotation, marks class as data access object / object dealing with domain (Aggregate Roots).
4. **@Controller** - class-level annotation, specialization of @Component. It marks a class as a web request handler. Mostly used with @RequestMapping annotation.

## Scopes ##

5 scopes

Valid in any configuration
- Singleton (default - single bean)
- Prototype (unique bean per request)

Valid in web-aware spring projects
- Request
- Session
- Global Session


### Spring MVC Annotations

