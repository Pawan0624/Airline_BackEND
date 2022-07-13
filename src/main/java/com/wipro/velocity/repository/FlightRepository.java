package com.wipro.velocity.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wipro.velocity.model.Flight;
@Repository
public interface FlightRepository extends MongoRepository<Flight, String>{


	@Query("{ 'source' : ?0,  'destination': ?1 }")
	List<Flight> findBySourceAndDestination(@Param("source") String source, @Param("destination")String destination);

}
