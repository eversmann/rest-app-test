package es.evers.beans;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Court {

	public enum SURFACE {
		HARD, SOFT
	};

	public enum SITUATION {
		INDOOR, OPEN_AIR
	};

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

	public Court() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}