package es.evers.beans;

public class Court extends BeanTemplate {

	public enum SURFACE {
		HARD, SOFT
	};

	public enum SITUATION {
		INDOOR, OUTDOOR
	};

	private String id;
	private Long number;
	private SURFACE surface;
	private SITUATION situation;
	private Long ownerId;

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long pOwnerId) {
		ownerId = pOwnerId;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long pNumber) {
		number = pNumber;
	}

	public SURFACE getSurface() {
		return surface;
	}

	public void setSurface(SURFACE pSurface) {
		surface = pSurface;
	}

	public SITUATION getSituation() {
		return situation;
	}

	public void setSituation(SITUATION pSituation) {
		situation = pSituation;
	}

	public String getId() {
		return id;
	}

	public void setId(String pId) {
		id = pId;
	}

}
