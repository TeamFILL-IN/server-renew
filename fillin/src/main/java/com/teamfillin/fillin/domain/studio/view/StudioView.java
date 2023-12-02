package com.teamfillin.fillin.domain.studio.view;

import com.teamfillin.fillin.domain.runningTime.OperationStatus;
import com.teamfillin.fillin.domain.studio.Studio;

public class StudioView {

	private final long no;
	private final String name;
	private final String address;
	private final String tel;
	private final double latitude;
	private final double longitude;
	private final String etc;
	private final String site;
	private StudioRunningStatus runningStatus;

	public StudioView(long no, String name, String address, String tel, double latitude, double longitude, String etc,
		String site) {
		this.no = no;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.latitude = latitude;
		this.longitude = longitude;
		this.etc = etc;
		this.site = site;
	}

	public static StudioView from(Studio studio) {
		return new StudioView(
			studio.getNo(),
			studio.getName(),
			studio.getAddress(),
			studio.getTel(),
			studio.getLatitude(),
			studio.getLongitude(),
			studio.getEtc(),
			studio.getSite()
		);
	}

	public void setRunningStatus(OperationStatus operationStatus) {
		if (operationStatus.isClosed()) {
			runningStatus = StudioRunningStatus.CLOSED;
		} else if (operationStatus.isBreakTime()) {
			runningStatus = StudioRunningStatus.BREAK_TIME;
		} else {
			runningStatus = StudioRunningStatus.OPEN;
		}
	}

	public long getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
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

	public String getRunningStatusValue() {
		return runningStatus.getValue();
	}
}
