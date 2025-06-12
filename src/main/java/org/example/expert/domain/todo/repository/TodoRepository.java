package org.example.expert.domain.todo.repository;

import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    //반환하는 데이터타입 Page
    @EntityGraph(attributePaths = "user")
    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);

    //반환하는 데이터타입 Optional
    @EntityGraph(attributePaths = "user")
    Optional<Todo> findById(Long todoId);

    int countById(Long todoId);
}

