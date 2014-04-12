package es.evers.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import es.evers.beans.Court;

public interface CourtRepository extends Repository<Court, Long> {

	Court save(Court court);

	Court findOne(Long primaryKey);

	List<Court> findBySurfaceAndOwnerId(Court.SURFACE surface, Long ownerId);

	List<Court> findByOwnerId(Long ownerId);

	Long count();

	void delete(Court entity);

	boolean exists(Long primaryKey);

}
