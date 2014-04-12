package es.evers.services.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.evers.beans.Court;
import es.evers.beans.Greeting;
import es.evers.manager.CourtManager;

@RestController
@RequestMapping("/services/*")
public class ServicesController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private CourtManager courtManager;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting getGreeting(
			@RequestParam(value = "name", required = false, defaultValue = "World!") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}

	@RequestMapping(value = "/listCourts/{owner}", method = RequestMethod.GET)
	public List<Court> getList(@PathVariable("owner") Long pOwnerId) {
		return getCourtManager().retrieveCourtsByOwnerId(pOwnerId);
	}

	public CourtManager getCourtManager() {
		return courtManager;
	}

	public void setCourtManager(CourtManager pCourtManager) {
		courtManager = pCourtManager;
	}

}