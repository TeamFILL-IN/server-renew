package com.teamfillin.fillin.domain.runningTime;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RunningTimeRetriever {

	private final RunningTimeRepository runningTimeRepository;

	public RunningTimeRetriever(RunningTimeRepository runningTimeRepository) {
		this.runningTimeRepository = runningTimeRepository;
	}

	public List<RunningTime> retrieveByStudioNo(long studioNo) {
		return runningTimeRepository.findByStudioNo(studioNo)
			.stream()
			.map(RunningTime::from)
			.toList();
	}
}
