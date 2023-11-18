package com.teamfillin.fillin.domain.reactionHistory;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ReactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false, unique = true)
	private Long userNo;

	@Column(nullable = false, unique = true)
	private Long targetNo;

	@Column(nullable = false, length = 50, unique = true)
	private TargetType targetType;

	@CreatedDate
	private LocalDateTime createdAt;

	protected ReactionHistory() {
	}

	public ReactionHistory(Long userNo, Long targetNo, TargetType targetType) {
		this.userNo = userNo;
		this.targetNo = targetNo;
		this.targetType = targetType;
	}
}
