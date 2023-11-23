package com.teamfillin.fillin.domain.reactionHistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.teamfillin.fillin.domain.common.BaseTimeEntity;

@Entity
@Table(
	name = "reaction_history",
	indexes = {
		@Index(name = "ux_reaction_user_and_target", columnList = "userNo, targetNo, targetType")
	}
)
public class ReactionHistory extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;

	@Column(nullable = false)
	private Long userNo;

	@Column(nullable = false)
	private Long targetNo;

	@Column(nullable = false, length = 50)
	private TargetType targetType;

	protected ReactionHistory() {
	}

	public ReactionHistory(Long userNo, Long targetNo, TargetType targetType) {
		this.userNo = userNo;
		this.targetNo = targetNo;
		this.targetType = targetType;
	}
}
