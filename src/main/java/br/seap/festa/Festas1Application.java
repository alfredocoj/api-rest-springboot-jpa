package br.seap.festa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.seap.festa.controller.ConvidadosController;
import br.seap.festa.service.ConvidadoService;

@SpringBootApplication(scanBasePackageClasses= {ConvidadosController.class, ConvidadoService.class})
@EnableJpaRepositories
public class Festas1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Festas1Application.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
