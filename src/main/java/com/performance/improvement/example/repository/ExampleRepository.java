package com.performance.improvement.example.repository;

import com.performance.improvement.example.model.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/*
    QueryDsl 사용 시 CustomRepository 상속 필요
 */
public interface ExampleRepository extends JpaRepository<Example, UUID>, ExampleCustomRepository {
}
