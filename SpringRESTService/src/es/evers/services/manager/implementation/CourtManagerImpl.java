package es.evers.services.manager.implementation;

import java.util.ArrayList;
import java.util.List;

import es.evers.services.beans.Court;

public class CourtManagerImpl implements CourtManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.evers.services.manager.implementation.CourtManager#retrieveCourts()
	 */
	@Override
	public List<Court> retrieveCourts() {
		List<Court> courts = new ArrayList<Court>();
		for (int i = 5; i != 0; i--) {
			Court court = new Court();
			court.setNumber(Long.valueOf(i));
			court.setSituation(i % 2 == 0 ? Court.SITUATION.INDOOR
					: Court.SITUATION.OPEN_AIR);
			court.setSurface(i % 2 != 0 ? Court.SURFACE.HARD
					: Court.SURFACE.SOFT);
			courts.add(court);
		}
		return courts;
	}
}
