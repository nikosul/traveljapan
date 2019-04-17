package ns.harjoitustyo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ActivitityRepository extends CrudRepository<Activity, Long> {

	List<Activity> findByType(String type);
	
	Optional<Activity> findById(Long activityId);
	
}
