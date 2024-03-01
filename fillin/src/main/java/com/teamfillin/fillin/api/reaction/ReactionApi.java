package com.teamfillin.fillin.api.reaction;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfillin.fillin.api.FillinApiResponse;
import com.teamfillin.fillin.domain.reaction.BookmarkReactionResult;
import com.teamfillin.fillin.domain.reaction.ReactionCreateCommand;
import com.teamfillin.fillin.domain.reaction.ReactionRegisterService;
import com.teamfillin.fillin.domain.reaction.ReactionRetrieveService;

@RestController
@RequestMapping("/reaction")
public class ReactionApi {

	private final ReactionRegisterService reactionRegisterService;
	private final ReactionRetrieveService reactionRetrieveService;

	public ReactionApi(ReactionRegisterService reactionRegisterService,
		ReactionRetrieveService reactionRetrieveService) {
		this.reactionRegisterService = reactionRegisterService;
		this.reactionRetrieveService = reactionRetrieveService;
	}

	@PostMapping("/{studioNo}")
	public ResponseEntity<FillinApiResponse> registerStudioReaction(@PathVariable long studioNo, long userNo) {
		ReactionCreateCommand reactionCreateCommand = new ReactionCreateCommand(userNo, studioNo);
		reactionRegisterService.registerStudioReaction(reactionCreateCommand);
		return FillinApiResponse.success(HttpStatus.CREATED);
	}

	@GetMapping("/studio")
	public ResponseEntity<FillinApiResponse> retrieve(long userNo) {
		List<BookmarkReactionResult> bookmarkReactionResults = reactionRetrieveService.retrieveBookmark(userNo);
		return FillinApiResponse.success(HttpStatus.OK, new BookmarkReactionResponse(bookmarkReactionResults));
	}
}
