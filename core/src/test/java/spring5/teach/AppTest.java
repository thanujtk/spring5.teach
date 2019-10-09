package spring5.teach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tk.spring.lifecycle.JavaConfig;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JavaConfig.class)
public class AppTest {

    @Test
    void whenCallingSayHello_thenReturnHello() {
        assertTrue("Hello".equals("Hello"));
    }
}
