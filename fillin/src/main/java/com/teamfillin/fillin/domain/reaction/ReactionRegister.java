package com.teamfillin.fillin.domain.reaction;

import org.springframework.stereotype.Component;

@Component
public class ReactionRegister {

	private final ReactionHistoryRepository reactionHistoryRepository;

	public ReactionRegister(ReactionHistoryRepository reactionHistoryRepository) {
		this.reactionHistoryRepository = reactionHistoryRepository;
	}

	public void registerStudio(long userNo, long studioNo) {
		reactionHistoryRepository.save(new ReactionHistoryEntity(userNo, studioNo, TargetType.STUDIO));
	}
}
