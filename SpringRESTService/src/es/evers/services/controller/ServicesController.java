package es.evers.services.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.evers.beans.Court;
import es.evers.beans.Court.SITUATION;
import es.evers.beans.Court.SURFACE;
import es.evers.manager.CourtManager;

@RestController
@RequestMapping("/services/*")
public class ServicesController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourtManager courtManager;

	@RequestMapping(value = "/listCourts/{owner}", method = RequestMethod.GET)
	public List<Court> getList(@PathVariable("owner") Long pOwnerId) {
		logger.debug("Requested: /listCourts/" + pOwnerId);
		return getCourtManager().retrieveCourtsByOwnerId(pOwnerId);
	}

	@RequestMapping(value = "/addCourt", method = RequestMethod.PUT)
	public void addCourt(
			@RequestParam(value = "number", required = true) Long pNumber,
			@RequestParam(value = "surface", required = true) String pSurface,
			@RequestParam(value = "situation", required = true) String pSituation,
			@RequestParam(value = "ownerId", required = true) Long pOwnerId) {

		logger.debug("Requested: /addCourt" + "number=" + pNumber + "surface="
				+ pSurface + "situation=" + pSituation + "ownerId=" + pOwnerId);

		Court court = new Court();
		court.setNumber(pNumber);
		court.setSurface(SURFACE.valueOf(pSurface));
		court.setSituation(SITUATION.valueOf(pSituation));
		court.setOwnerId(pOwnerId);
		logger.debug(court.toString());
		getCourtManager().addCourt(court);
	}

	public CourtManager getCourtManager() {
		return courtManager;
	}

	public void setCourtManager(CourtManager pCourtManager) {
		courtManager = pCourtManager;
	}

}