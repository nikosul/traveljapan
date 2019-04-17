package ns.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long cityId;
	private String name;
	private String prefecture;
	private String region;
	private String aerial;
	private int population;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	
	private List<Activity> activities;
	
	public City() {
		
	}
	
	public City(String name, String prefecture, String region, String aerial, int population) {
		super();
		this.name = name;
		this.prefecture = prefecture;
		this.region = region;
		this.aerial = aerial;
		this.population = population;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAerial() {
		return aerial;
	}

	public void setAerial(String aerial) {
		this.aerial = aerial;
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public String toString() {
			return "City [cityId=" + cityId + ", name=" + name + ", prefecture=" + prefecture + ", region=" + region
					+ ", aerial=" + aerial + ", population=" + population + "]";
		}
}