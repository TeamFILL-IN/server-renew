package com.teamfillin.fillin.domain.account;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	Optional<AccountEntity> findAccountBySocialInfo(@NotNull AccountEntity.SocialInfo socialInfo);
}
