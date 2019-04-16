package ns.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Overnight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long OvernightId;
	private String OvernightType;
	private String Nights;
	private int OvernightPrice;
	
	public Overnight() {
		
	}
	
	public Overnight(String OvernightType, String Nights, int OvernightPrice) {
		super();
		this.OvernightType = OvernightType;
		this.Nights = Nights;
		this.OvernightPrice = OvernightPrice;
	}

	public Long getOvernightId() {
		return OvernightId;
	}

	public void setOvernightId(Long OvernightId) {
		this.OvernightId = OvernightId;
	}

	public String getOvernightType() {
		return OvernightType;
	}

	public void setOvernightType(String overnightType) {
		OvernightType = overnightType;
	}

	public String getNights() {
		return Nights;
	}

	public void setNights(String nights) {
		Nights = nights;
	}

	public int getOvernightPrice() {
		return OvernightPrice;
	}

	public void setOvernightPrice(int overnightPrice) {
		OvernightPrice = overnightPrice;
	}

	@Override
	public String toString() {
		return "Overnight [OvernightId=" + OvernightId + ", OvernightType=" + OvernightType + ", Nights=" + Nights
				+ ", OvernightPrice=" + OvernightPrice + "]";
	}
}
