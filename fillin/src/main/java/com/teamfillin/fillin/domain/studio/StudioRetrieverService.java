package com.teamfillin.fillin.domain.studio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StudioRetrieverService {

	private final StudioRetriever studioRetriever;

	public StudioRetrieverService(StudioRetriever studioRetriever) {
		this.studioRetriever = studioRetriever;
	}

	public List<StudioLocationResult> retrieveAllStudio() {
		return studioRetriever.retrieveAll()
			.stream()
			.map(StudioLocationResult::from)
			.toList();
	}
}
