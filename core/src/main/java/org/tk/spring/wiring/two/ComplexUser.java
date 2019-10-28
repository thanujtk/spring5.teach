package org.tk.spring.wiring.two;

import org.springframework.stereotype.Component;
import org.tk.spring.wiring.User;

//example to show how component scan works (MainWiring)
@Component
public class ComplexUser implements User {
    @Override
    public String getUser() {
        return "Complex User";
    }
}
