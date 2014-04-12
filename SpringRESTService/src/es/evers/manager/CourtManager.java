package es.evers.manager;

import java.util.List;

import es.evers.beans.Court;

public interface CourtManager {

	public abstract List<Court> retrieveCourtsByOwnerId(Long pOwnerId);

}