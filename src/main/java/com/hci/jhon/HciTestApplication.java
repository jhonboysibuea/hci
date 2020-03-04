package com.hci.jhon;

import com.hci.jhon.model.GroupHomePage;
import com.hci.jhon.model.Modules;
import com.hci.jhon.model.User;
import com.hci.jhon.repository.GroupHomePageRepository;
import com.hci.jhon.repository.ModulesRepository;
import com.hci.jhon.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.hci.jhon.repository")
public class HciTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HciTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(UserRepository userRepository, ModulesRepository modulesRepository, GroupHomePageRepository groupHomePageRepository) {
		return args -> {
			GroupHomePage groupHomePage=GroupHomePage.builder().name("group1")
					.build();
			groupHomePageRepository.save(groupHomePage);
			User user= User.builder()
					.name("JHon")
					.groupHomePage(groupHomePage)
					.build();
			userRepository.save(user);
			Modules modules1=Modules.builder()

					.moduleName("PromoCard")
					.groupHomePage(groupHomePage)
					.moduleOrder(1)
					.build();

			Modules modules2=Modules.builder()

					.moduleName("CategoryCard")
					.groupHomePage(groupHomePage)
					.moduleOrder(2)
					.build();
			Modules modules3=Modules.builder()

					.moduleName("FlashSaleCard")
					.groupHomePage(groupHomePage)
					.moduleOrder(3)
					.build();
			Modules modules4=Modules.builder()

					.moduleName("HistoryCard")
					.groupHomePage(groupHomePage)
					.moduleOrder(4)
					.build();
			Modules modules5=Modules.builder()

					.moduleName("NewsCard")
					.groupHomePage(groupHomePage)
					.moduleOrder(5)
					.build();
			modulesRepository.save(modules1);
			modulesRepository.save(modules2);
			modulesRepository.save(modules3);
			modulesRepository.save(modules4);
			modulesRepository.save(modules5);

		};
	}

}
