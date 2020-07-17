package learner.springframework.msscbrewery.services.v2;

import java.util.UUID;

import learner.springframework.msscbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {

	BeerDtoV2 getBeerById(UUID beerId);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto2);

	void updateBeer(UUID beerId, BeerDtoV2 beerDto2);

	void deleteById(UUID beerId);

}
