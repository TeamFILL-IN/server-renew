package com.teamfillin.fillin.domain.studio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<StudioEntity, Long> {

	@Query(value =
		"SELECT s.* FROM studio s "
			+ "WHERE MATCH(s.name, s.address) "
			+ "AGAINST(:searchKeyword IN BOOLEAN MODE)", nativeQuery = true)
	List<StudioEntity> searchByKeywordInBooleanMode(String searchKeyword);
}
