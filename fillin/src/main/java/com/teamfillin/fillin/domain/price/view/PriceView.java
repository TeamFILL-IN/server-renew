package com.teamfillin.fillin.domain.studio.view;

import java.util.List;
import java.util.StringJoiner;

import javax.annotation.Nullable;

import com.teamfillin.fillin.domain.price.Price;

public class PriceView {

	private static final String SPACE = " ";
	private static final String LINE_BREAK = "\n";

	private final List<Price> values;

	public PriceView(List<Price> values) {
		this.values = values;
	}

	@Nullable
	public String getPriceInfo() {
		if (values.isEmpty()) {
			return null;
		}
		if (values.size() == 1) {
			Price price = values.get(0);
			if (price.getName() == null) {
				return String.valueOf(price.getAmount());
			}
			return price.getName() + SPACE + price.getAmount();
		}
		StringJoiner sj = new StringJoiner(LINE_BREAK);
		for (Price value : values) {
			String priceInfo = value.getName() + SPACE + value.getAmount();
			sj.add(priceInfo);
		}
		return sj.toString();
	}
}
