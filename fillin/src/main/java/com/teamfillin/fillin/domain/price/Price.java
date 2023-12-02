package com.teamfillin.fillin.domain.price;

import java.util.Objects;

public class Price {

	private final long studioNo;
	private final String name;
	private final int amount;

	private Price(long studioNo, String name, int amount) {
		this.studioNo = studioNo;
		this.name = name;
		this.amount = amount;
	}

	public static Price from(PriceEntity priceEntity) {
		return new Price(priceEntity.getStudioNo(), priceEntity.getName(), priceEntity.getAmount());
	}

	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Price price = (Price)o;
		return studioNo == price.studioNo && amount == price.amount && Objects.equals(name, price.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(studioNo, name, amount);
	}
}
