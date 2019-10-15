package org.tk.spring.wiring.auto;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Map;

@Data
public class BeanA {

    //applicationContext2.xml has 3 BeanB instances configured with different bean name;
    @Autowired
    private BeanB[] beanBs;

    @Autowired
    private List<BeanB> beanBList;

    @Autowired
    private Map<String, BeanB> beanBMap;

    @Autowired //Automatically injected by container
    ApplicationContext applicationContext;
}
