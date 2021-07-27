package org.tk.spring.ehcache;


import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URL;

//https://www.baeldung.com/spring-boot-ehcache

@Configuration
//@EnableCaching //CacheManager bean is registered so no need to have this annotation, see above link for spring-boot
public class EhCacheJavaConfig {

    //Programmatic - https://www.ehcache.org/documentation/3.3/getting-started.html
    @Bean ("ehcacheManager")
    @Primary
    public CacheManager cacheManager() {
        URL url = Thread.currentThread().getContextClassLoader().getResource("ehcache.xml");
        org.ehcache.config.Configuration xmlConfig = new XmlConfiguration(url);
        CacheManager manager = CacheManagerBuilder.newCacheManager(xmlConfig);
        return manager;
    }
}
