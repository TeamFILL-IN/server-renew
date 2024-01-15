package com.teamfillin.fillin.api.studio;

import com.teamfillin.fillin.domain.price.view.PriceView;
import com.teamfillin.fillin.domain.runningTime.view.RunningTimeView;
import com.teamfillin.fillin.domain.studio.Studio;
import com.teamfillin.fillin.domain.studio.StudioDetailResult;

public class StudioDetailResponse {

	private final long id;
	private final String name;
	private final String address;
	private final String price;
	private final String time;
	private final String tel;
	private final double latitude;
	private final double longitude;
	private final String etc;
	private final String site;
	private final String runningStatus;

	private StudioDetailResponse(long id, String name, String address, String price, String time, String tel,
		double latitude, double longitude, String etc, String site, String runningStatus) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.price = price;
		this.time = time;
		this.tel = tel;
		this.latitude = latitude;
		this.longitude = longitude;
		this.etc = etc;
		this.site = site;
		this.runningStatus = runningStatus;
	}

	public static StudioDetailResponse from(StudioDetailResult detailResult) {
		Studio studio = detailResult.getStudio();
		PriceView priceView = detailResult.getPriceView();
		RunningTimeView runningTimeView = detailResult.getRunningTimeView();
		return new StudioDetailResponse(
			studio.getNo(),
			studio.getName(),
			studio.getAddress(),
			priceView.getPriceInfo(),
			runningTimeView.getRunningTimeInfo(),
			studio.getTel(),
			studio.getLatitude(),
			studio.getLongitude(),
			studio.getEtc(),
			studio.getSite(),
			studio.getRunningStatusValue()
		);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPrice() {
		return price;
	}

	public String getTime() {
		return time;
	}

	public String getTel() {
		return tel;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getEtc() {
		return etc;
	}

	public String getSite() {
		return site;
	}

	public String getRunningStatus() {
		return runningStatus;
	}
}
