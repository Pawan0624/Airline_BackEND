package com.wipro.velocity.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.velocity.exception.ResourceNotFoundException;
import com.wipro.velocity.model.Flight;
import com.wipro.velocity.repository.FlightRepository;

@RestController
@RequestMapping("/Airline")
@CrossOrigin(origins="http://localhost:4200")
public class FlightRestController {

	@Autowired
	private FlightRepository frepo;

	@PostMapping("/flight")
	public Flight createFlight(@Validated @RequestBody Flight flight)
	{

		Flight f = new Flight();
		f.setSource(flight.getSource());
		f.setDestination(flight.getDestination());
		f.setDeparture(flight.getDeparture());
		f.setArrival(flight.getArrival());
		f.setDate(flight.getDate());
		f.setDuration(flight.getDuration());
		f.setPassengers(flight.getPassengers());
		f.setCapacity(flight.getCapacity());
		f.setEconomy(flight.getEconomy());
		f.setBuiseness(flight.getBuiseness());

		Flight generated = frepo.save(f);
		return generated;
	}


	@GetMapping("/flight/{fNumber}")
	public ResponseEntity<Flight> getFlightById(@PathVariable(value = "fNumber") String fNumber)
			throws ResourceNotFoundException {
		Flight flight = frepo.findById(fNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not found for this id :: " + fNumber));

		return ResponseEntity.ok().body(flight);
	}

	@DeleteMapping("/flight/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") String id) throws ResourceNotFoundException{

		Flight flight = frepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight not found for this id :: " + id));
		frepo.delete(flight);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return response;
	}

	// In Postman - PUT - http://localhost:8086/airline/flight/id
	//Body - raw - Json - Enter Json object - Send
	@PutMapping("/flight/{fNumber}")
	public ResponseEntity<Flight> updateProduct(@PathVariable(value = "fNumber") String fNumber,
			@Validated @RequestBody Flight f) throws ResourceNotFoundException {

		Flight flight = frepo.findById(fNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + fNumber));


		flight.setSource(f.getSource());
		flight.setDestination(f.getDestination());
		flight.setDeparture(f.getDeparture());
		flight.setArrival(f.getArrival());
		flight.setDate(f.getDate());
		flight.setDuration(f.getDuration());
		flight.setPassengers(f.getPassengers());
		flight.setEconomy(f.getEconomy());
		flight.setBuiseness(f.getBuiseness());

		final Flight updatedProduct = frepo.save(flight);
		return ResponseEntity.ok(updatedProduct);
	}

	// Browse - http://localhost:8080/Airline/flight/source/destination
	@GetMapping("/flight/{source}/{destination}")
	public List<Flight> getAllProducts(@PathVariable(value = "source") String source, @PathVariable(value = "destination") String destination) {
		return frepo.findBySourceAndDestination(source,destination);
	}

}
