package com.performance.improvement.example.repository;

import com.performance.improvement.example.model.entity.Example;

import java.util.List;

/*
    QueryDsl 사용 예시
 */
public interface ExampleCustomRepository {
    List<Example> findExamplesByTitle(String title);
}
