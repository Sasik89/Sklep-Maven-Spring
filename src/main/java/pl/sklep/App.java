package pl.sklep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.sklep.configuration.AppConfiguration;
import pl.sklep.core.ICore;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfiguration.class);
        ICore core = context.getBean(ICore.class);
        core.start();

    }
}