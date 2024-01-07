package com.teamfillin.fillin.domain.photo;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;

import com.teamfillin.fillin.resource.Image;

public class Photo {
	private final long no;
	private final Image image;
	private final PhotoFilm film;
	private final PhotoStatus status;
	private final PhotoLikeReaction reaction;
	private final Publisher publisher;

	// TODO: studio 작업 머지 후 반영
	// private final Studio studio;

	public Photo(
		long no,
		@NotNull Image image,
		@NotNull PhotoFilm film,
		@NotNull PhotoStatus status,
		@NotNull PhotoLikeReaction reaction,
		@NotNull Publisher publisher
	) {
		this.no = no;
		this.image = image;
		this.film = film;
		this.status = status;
		this.reaction = reaction;
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, image, film, status, reaction, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			Photo target = (Photo)obj;
			return no == target.no && status == target.status
				&& Objects.equals(image, target.image)
				&& Objects.equals(film, target.film)
				&& Objects.equals(reaction, target.reaction)
				&& Objects.equals(publisher, target.publisher);
		}
		return false;
	}
}
