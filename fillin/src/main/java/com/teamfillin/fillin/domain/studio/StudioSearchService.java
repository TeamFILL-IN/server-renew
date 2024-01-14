package com.teamfillin.fillin.domain.studio;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class StudioSearchService {

	private final StudioSearcher studioSearcher;

	public StudioSearchService(StudioSearcher studioSearcher) {
		this.studioSearcher = studioSearcher;
	}

	public List<StudioSearchResult> searchStudio(InputKeywordCommand inputKeywordCommand) {
		return studioSearcher.searchByKeyword(inputKeywordCommand)
			.stream()
			.map(StudioSearchResult::from)
			.toList();
	}
}
