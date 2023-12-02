package com.teamfillin.fillin.domain.price;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

	List<PriceEntity> findByStudioNo(Long studioNo);
}
