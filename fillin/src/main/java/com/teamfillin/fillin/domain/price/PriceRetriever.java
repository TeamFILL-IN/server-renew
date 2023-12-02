package com.teamfillin.fillin.domain.price;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PriceRetriever {

	private final PriceRepository priceRepository;

	public PriceRetriever(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	public List<Price> retrieveByStudioNo(long studioNo) {
		return priceRepository.findByStudioNo(studioNo)
			.stream()
			.map(Price::from)
			.toList();
	}
}
