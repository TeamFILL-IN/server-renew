package com.teamfillin.fillin.domain.studio;

import com.teamfillin.fillin.domain.price.view.PriceView;
import com.teamfillin.fillin.domain.runningTime.view.RunningTimeView;

public class StudioDetailResult {

	private final Studio studio;
	private final PriceView priceView;
	private final RunningTimeView runningTimeView;

	public StudioDetailResult(Studio studio, PriceView priceView, RunningTimeView runningTimeView) {
		this.studio = studio;
		this.priceView = priceView;
		this.runningTimeView = runningTimeView;
	}

	public Studio getStudio() {
		return studio;
	}

	public PriceView getPriceView() {
		return priceView;
	}

	public RunningTimeView getRunningTimeView() {
		return runningTimeView;
	}
}
