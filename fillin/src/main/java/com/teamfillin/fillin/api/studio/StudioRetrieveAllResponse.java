package com.teamfillin.fillin.api.studio;

import java.util.List;

import com.teamfillin.fillin.domain.studio.StudioLocationResult;

public class StudioRetrieveAllResponse {

	private final List<StudioLocationResult> studios;

	public StudioRetrieveAllResponse(List<StudioLocationResult> studios) {
		this.studios = studios;
	}

	public List<StudioLocationResult> getStudios() {
		return studios;
	}
}
