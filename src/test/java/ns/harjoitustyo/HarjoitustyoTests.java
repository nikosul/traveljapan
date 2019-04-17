package ns.harjoitustyo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ns.harjoitustyo.domain.City;
import ns.harjoitustyo.domain.CityRepository;
import ns.harjoitustyo.domain.User;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest

public class HarjoitustyoTests {
	
	@Autowired
	private CityRepository crepo;

	@Test
	public void findByPopulation() {
		List<City> cities = crepo.findByPopulation(8673098);
		assertThat(cities).hasSize(1);
		assertThat(cities.get(0).getPopulation()).isEqualTo(8673098);
	}
	
	@Test
	public void findByName() {
		List<City> cities = crepo.findByName("Sapporo");
		assertThat(cities).hasSize(1);
		assertThat(cities.get(0).getName()).isEqualTo("Sapporo");
	}

	@Test
	public void CreateCity() {
		new City("test", "test", "test", "test", 123);
	}
	@Test
	public void CreateUser() {
		new User("salainen1", "salainen1", "salainen@1.nen", ("USER"));
	}
	@Test
	public void deleteCity() {
		List<City> cities = crepo.deleteByName("Tokyo");
		assertThat(cities).hasSize(1);
		assertThat(cities.get(0).getName()).isEqualTo("Tokyo");
	}
}
