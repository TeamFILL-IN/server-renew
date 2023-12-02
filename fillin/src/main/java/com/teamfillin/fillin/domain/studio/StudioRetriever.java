package com.teamfillin.fillin.domain.studio;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StudioRetriever {

	private final StudioRepository studioRepository;

	public StudioRetriever(StudioRepository studioRepository) {
		this.studioRepository = studioRepository;
	}

	public List<Studio> retrieveAll() {
		return studioRepository.findAll()
			.stream()
			.map(Studio::from)
			.toList();
	}

	public Studio retrieveOne(long studioNo) {
		return studioRepository.findById(studioNo)
			.map(Studio::from)
			.orElseThrow(StudioExceptionHandler::notFount);
	}
}
