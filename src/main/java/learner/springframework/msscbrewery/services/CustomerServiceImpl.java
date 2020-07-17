package learner.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import learner.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.customerName("Joe Buck")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		// TODO impl - will add a real impl
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug("deletion in progress");		
	}

}
