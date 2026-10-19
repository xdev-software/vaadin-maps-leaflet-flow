package software.xdev.vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.spring.annotation.EnableVaadin;
import com.vaadin.flow.theme.lumo.Lumo;


@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@EnableVaadin
@Push
@StyleSheet(Lumo.STYLESHEET)
public class Application extends SpringBootServletInitializer implements AppShellConfigurator
{
	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}

