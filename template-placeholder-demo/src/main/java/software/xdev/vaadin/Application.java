package software.xdev.vaadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.spring.annotation.EnableVaadin;


@SuppressWarnings({"checkstyle:HideUtilityClassConstructor", "PMD.UseUtilityClass"})
@SpringBootApplication
@EnableVaadin
@Push
public class Application extends SpringBootServletInitializer implements AppShellConfigurator
{
	public static void main(final String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
}

