package ns.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import ns.harjoitustyo.domain.Activity;
import ns.harjoitustyo.domain.ActivitityRepository;
import ns.harjoitustyo.domain.City;
import ns.harjoitustyo.domain.CityRepository;
import ns.harjoitustyo.domain.User;
import ns.harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication extends SpringBootServletInitializer {
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		
		return application.sources(HarjoitustyoApplication.class);	
	}
	
	private static final Logger dataLog = LoggerFactory.getLogger(HarjoitustyoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testLogData(CityRepository crepo, ActivitityRepository arepo, UserRepository urepo) {
		return (args) -> {
			
			dataLog.info("Getting ready to log data... 1, 2, 3...");
			

			
			
			// cityId 1
			crepo.save(new City("Tokyo", "Tokyo", "Kantō", "Eastern-Coast of Japan", 1000000));
			
			// cityId2
			crepo.save(new City("Ōsaka", "Osaka", "Kansai", "South-Eastern Coast of Japan", 1000000));
			
			// 3
			crepo.save(new City("Yokohama", "Kanagawa", "Kantō", "Eastern-Coast of Japan", 1000000));
			
			// 4
			crepo.save(new City("Nagoya", "Aichi", "Chūbu", "Central-Coast of Japan", 1000000));
			
			// 5
			crepo.save(new City("Tokyo", "Tokyo", "Kantō", "Eastern-Coast of Japan", 1000000));
			
			// 6
			crepo.save(new City("Ōsaka", "Osaka", "Kansai", "South-Eastern Coast of Japan", 1000000));
			
			// 7
			crepo.save(new City("Yokohama", "Kanagawa", "Kantō", "Eastern-Coast of Japan", 1000000));
			
			// 8
			crepo.save(new City("Nagoya", "Aichi", "Chūbu", "Central-Coast of Japan", 1000000));
			
			// 9
			crepo.save(new City("Tokyo", "Tokyo", "Kantō", "Eastern-Coast of Japan", 1000000));
			
			// 10
			crepo.save(new City("Ōsaka", "Osaka", "Kansai", "South-Eastern Coast of Japan", 1000000));
			
			// Activities...
			// activityId 1
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(1).get(0)));
			
			// 2
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(2).get(0)));
			
			// 3
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(3).get(0)));
			
			// 4
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(4).get(0)));
			
			// 5
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(5).get(0)));
			
			// 6
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(6).get(0)));
			
			// 7
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(7).get(0)));
			
			// 8
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(8).get(0)));
			
			// 9
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(9).get(0)));
			
			//10
			arepo.save(new Activity("Sightseeing, Culture, Nightlife, Food, Beaches", crepo.findById(10).get(0)));
			
			
//			dataLog.info("Test data of all cities");
//				for (City city : crepo.findAll()) {
//					dataLog.info(city.toString());
//			}
			
			// TEST USERS // username, password, email, user role	
			User user = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "test@user.com", "USER");
			User admin = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "test@admin.com", "ADMIN");
			urepo.save(user);
			urepo.save(admin);
		};
	}
}
