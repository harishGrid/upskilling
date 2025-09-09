package com.command.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.command.entity.UserAccount;
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {}