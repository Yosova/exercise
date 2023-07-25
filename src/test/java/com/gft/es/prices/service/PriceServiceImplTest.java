package com.gft.es.prices.service;

import com.gft.es.prices.application.repository.PriceRepository;
import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.application.service.impl.PriceServiceImpl;
import com.gft.es.prices.domain.PriceModel;
import com.gft.es.prices.infrastructure.controller.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/*@ExtendWith(SpringExtension.class)
@SpringBootTest*/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceServiceImplTest {

	@Autowired
	public PriceService priceService;

	@MockBean
	public PriceRepository priceRepository;

	@Test
	void filterReturnOk() throws Exception {
		FilterIn filterIn = getFilter();
		when(priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(filterIn.getProductId(), filterIn.getBrandId(), filterIn.getApplicationDate(), filterIn.getApplicationDate()))
				.thenReturn(Optional.of(getPriceModel()));
		PricesOut filter = priceService.filter(filterIn);
		assertNotNull(filter);
	}

	@Test
	void filterReturnBadRequest()  {
		Exception exception = assertThrows(HttpClientErrorException.class, () -> {
			priceService.filter(FilterIn.builder().build());
		});
		assertNotNull(exception);
	}
	private FilterIn getFilter(){
		return FilterIn.builder()
				.brandId(1)
				.productId(35455)
				.build();
	}

	private PriceModel getPriceModel(){
		String str = "2020-06-15 10.00.00";
		String str1 = "2020-06-15 11.00.00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss");
		LocalDateTime startDate = LocalDateTime.parse(str, formatter);
		LocalDateTime enDate = LocalDateTime.parse(str1, formatter);
		return PriceModel.builder()
				.price(30.5)
				.productId(35455)
				.priceList(1)
				.brandId(1)
				.startDate(startDate)
				.endDate(enDate)
				.curr("EUR")
				.id(1L)
				.priority(1)
				.build();
	}
}