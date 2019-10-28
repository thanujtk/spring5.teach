package org.tk.spring.wiring.one;

import org.springframework.stereotype.Component;
import org.tk.spring.wiring.User;

//example to show how component scan works (MainWiring)
@Component
public class SimpleUser implements User {
    @Override
    public String getUser() {
        return "Simple User";
    }
}
