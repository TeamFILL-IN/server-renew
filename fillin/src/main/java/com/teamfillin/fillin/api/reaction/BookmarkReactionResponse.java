package com.teamfillin.fillin.api.reaction;

import java.util.List;

import com.teamfillin.fillin.domain.reaction.BookmarkReactionResult;

public class BookmarkReactionResponse {

	private final List<BookmarkReactionResult> bookmarks;

	public BookmarkReactionResponse(List<BookmarkReactionResult> bookmarks) {
		this.bookmarks = bookmarks;
	}

	public List<BookmarkReactionResult> getBookmarks() {
		return bookmarks;
	}
}
