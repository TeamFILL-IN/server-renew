package com.teamfillin.fillin.domain.runningTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunningTimeRepository extends JpaRepository<RunningTimeEntity, Long> {

	List<RunningTimeEntity> findByStudioNo(Long studioNo);
}
