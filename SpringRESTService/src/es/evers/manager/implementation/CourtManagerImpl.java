package es.evers.manager.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import es.evers.beans.Court;
import es.evers.manager.CourtManager;

public class CourtManagerImpl implements CourtManager {

	@Autowired
	private MongoOperations mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.evers.services.manager.implementation.CourtManager#retrieveCourtsByOwnerId()
	 */
	@Override
	public List<Court> retrieveCourtsByOwnerId(Long ownerId) {
		Query query = new Query(Criteria.where("ownerId").is(ownerId));
		return getMongoTemplate().find(query, Court.class);
	}

	public MongoOperations getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoOperations pMongoTemplate) {
		mongoTemplate = pMongoTemplate;
	}

}
