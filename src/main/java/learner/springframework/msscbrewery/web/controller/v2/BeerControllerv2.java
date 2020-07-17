package learner.springframework.msscbrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import learner.springframework.msscbrewery.services.v2.BeerServiceV2;
import learner.springframework.msscbrewery.web.model.v2.BeerDtoV2;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerv2 {

	@Autowired
	private BeerServiceV2 beerServiceV2;
	
	@GetMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId){
		
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDtoV2> handlePost(@RequestBody BeerDtoV2 beerDto2){
		BeerDtoV2 savedDto =  beerServiceV2.saveNewBeer(beerDto2);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/"+savedDto.getId().toString());
		return new ResponseEntity<BeerDtoV2>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{beerId}"})
	public ResponseEntity<BeerDtoV2> handlePut(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto2){
		beerServiceV2.updateBeer(beerId, beerDto2);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{beerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleDelete(@PathVariable UUID beerId){
		beerServiceV2.deleteById(beerId);
	}
}
