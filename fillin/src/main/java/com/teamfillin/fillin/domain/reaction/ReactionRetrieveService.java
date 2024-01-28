package com.teamfillin.fillin.domain.reaction;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReactionRetrieveService {

	private final ReactionRetriever reactionRetriever;

	public ReactionRetrieveService(ReactionRetriever reactionRetriever) {
		this.reactionRetriever = reactionRetriever;
	}

	public List<BookmarkReactionResult> retrieveBookmark(long userNo) {
		return reactionRetriever.retrieveBookmark(userNo)
			.stream()
			.map(bookmarkReaction -> new BookmarkReactionResult(
				bookmarkReaction.getTargetNo(),
				bookmarkReaction.getName(),
				bookmarkReaction.getAddress()
			))
			.toList();
	}
}
