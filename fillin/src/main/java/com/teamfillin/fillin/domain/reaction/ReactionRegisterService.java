package com.teamfillin.fillin.domain.reaction;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ReactionRegisterService {

	private final ReactionRegister reactionRegister;

	public ReactionRegisterService(ReactionRegister reactionRegister) {
		this.reactionRegister = reactionRegister;
	}

	public void registerStudioReaction(@NotNull ReactionCreateCommand command) {
		reactionRegister.registerStudio(command.getUserNo(), command.getTargetNo());
	}
}
