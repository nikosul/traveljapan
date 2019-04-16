package ns.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long activityId;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "cityId")
	@JsonIgnore
	private City city;

	public Activity() {
		
	}
	
	public Activity(String type, City city) {
		super();
		this.type = type;
		this.city = city;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Activities [activityId=" + activityId + ", type=" + type + ", + city=" + city + "]";
	}
}
