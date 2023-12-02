package com.teamfillin.fillin.domain.studio;

import java.time.Clock;
import java.time.LocalTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfillin.fillin.api.studio.StudioDetailResponse;
import com.teamfillin.fillin.domain.studio.view.StudioView;
import com.teamfillin.fillin.domain.price.PriceRetriever;
import com.teamfillin.fillin.domain.price.view.PriceView;
import com.teamfillin.fillin.domain.runningTime.RunningTimeRetriever;
import com.teamfillin.fillin.domain.runningTime.view.RunningTimeView;

@Service
@Transactional(readOnly = true)
public class StudioDetailRetrieveService {

	private final StudioRetriever studioRetriever;
	private final PriceRetriever priceRetriever;
	private final RunningTimeRetriever runningTimeRetriever;
	private final Clock koreaTimeClock;

	public StudioDetailRetrieveService(StudioRetriever studioRetriever, PriceRetriever priceRetriever,
		RunningTimeRetriever runningTimeRetriever, Clock koreaTimeClock) {
		this.studioRetriever = studioRetriever;
		this.priceRetriever = priceRetriever;
		this.runningTimeRetriever = runningTimeRetriever;
		this.koreaTimeClock = koreaTimeClock;
	}

	public StudioDetailResponse retrieveDetail(long studioNo) {
		StudioView studioView = StudioView.from(studioRetriever.retrieveOne(studioNo));
		PriceView priceView = new PriceView(priceRetriever.retrieveByStudioNo(studioNo));
		RunningTimeView runningTimeView = new RunningTimeView(runningTimeRetriever.retrieveByStudioNo(studioNo));
		studioView.setRunningStatus(runningTimeView.getCurrentOperationStatus(LocalTime.now(koreaTimeClock)));
		return StudioDetailResponse.of(studioView, priceView, runningTimeView);
	}
}
