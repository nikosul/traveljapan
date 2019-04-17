package ns.harjoitustyo.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
	
	List<City> findByName(String name);

	List<City> findById(long cityId);

	List<City> findByPrefecture(String prefecture);

	List<City> findByPopulation(int i);

	List<City> deleteByName(String string);
	
	
	
}
