package com.query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.query.entity.UserQuery;
import com.query.repo.UserQueryRepository;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserQueryController {
    @Autowired
    private UserQueryRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<UserQuery> getUserById(@PathVariable String id) {
        Optional<UserQuery> user = repository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}