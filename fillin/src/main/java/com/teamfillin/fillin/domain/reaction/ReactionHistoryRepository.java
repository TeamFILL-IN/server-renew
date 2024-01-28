package com.teamfillin.fillin.domain.reaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionHistoryRepository extends JpaRepository<ReactionHistoryEntity, Long> {

	@Query("SELECT rh.targetType AS type, rh.targetNo AS targetNo, s.name AS name, s.address AS address "
		+ "FROM ReactionHistoryEntity rh "
		+ "INNER JOIN StudioEntity s ON rh.targetNo = s.no AND rh.userNo = :userNo")
	List<BookmarkReactionProjection> findBy(long userNo);
}
