package com.query.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.query.entity.UserQuery;
public interface UserQueryRepository extends JpaRepository<UserQuery, String> {}