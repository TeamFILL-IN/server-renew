package com.teamfillin.fillin.domain.studio;

import java.util.List;
import java.util.stream.Collectors;

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
			.collect(Collectors.toList());
	}
}
