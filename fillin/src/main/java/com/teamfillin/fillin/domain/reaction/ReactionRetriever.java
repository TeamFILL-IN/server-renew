package com.teamfillin.fillin.domain.reaction;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class ReactionRetriever {

	private final ReactionHistoryRepository reactionHistoryRepository;

	public ReactionRetriever(ReactionHistoryRepository reactionHistoryRepository) {
		this.reactionHistoryRepository = reactionHistoryRepository;
	}

	public List<BookmarkReaction> retrieveBookmark(long userNo) {
		return reactionHistoryRepository.findBy(userNo)
			.stream()
			.map(projection -> BookmarkReaction.of(
				new ReactionId(projection.getType(), projection.getTargetNo()),
				projection.getName(),
				projection.getAddress()
			))
			.collect(Collectors.toList());
	}
}
