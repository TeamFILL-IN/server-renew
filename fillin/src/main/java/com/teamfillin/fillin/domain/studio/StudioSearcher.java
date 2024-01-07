package com.teamfillin.fillin.domain.studio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudioSearcher {

	private final StudioRepository studioSearchRepository;

	public StudioSearcher(StudioRepository studioSearchRepository) {
		this.studioSearchRepository = studioSearchRepository;
	}

	public List<Studio> searchByKeyword(InputKeyword inputKeyword) {
		KeywordManager keywordManager = KeywordManager.from(inputKeyword);
		String searchKeyword = keywordManager.makeSearchKeyword();
		return studioSearchRepository.searchByKeywordInBooleanMode(searchKeyword)
			.stream()
			.map(StudioEntity::toStudio)
			.toList();
	}
}
