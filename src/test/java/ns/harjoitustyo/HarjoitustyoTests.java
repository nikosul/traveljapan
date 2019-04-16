package ns.harjoitustyo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ns.harjoitustyo.domain.ActivitityRepository;
import ns.harjoitustyo.domain.City;
import ns.harjoitustyo.domain.CityRepository;
import ns.harjoitustyo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest

public class HarjoitustyoTests {
	
	@Autowired
	CityRepository crepo;
	
	@Autowired
	ActivitityRepository arepo;

	@Test
	public void findByName() {
		List<City> cities = crepo.findByName("Tokyo");
		assertThat(cities).hasSize(1);
		assertThat(cities.get(0).getName()).isEqualTo("Tokyo");
	}
	@Test
	public void findByPrefecture() {
		List<City> cities = crepo.findByPrefecture("Tokyo");
		assertThat(cities).hasSize(1);
		assertThat(cities.get(0).getPrefecture()).isEqualTo("Tokyo");
	}
//	@Test
//	public void CreateCity() {
//		City city = new City("test", "test", "test", "test", 123);
//	}
//	@Test
//	public void CreateUser() {
//		User user = new User("salainen1", "salainen1", "salainen@1.nen", ("USER"));
//	}
}
