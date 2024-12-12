package com.performance.improvement.example.repository;

import com.performance.improvement.example.model.entity.Example;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.performance.improvement.example.model.entity.QExample.example;

@RequiredArgsConstructor
public class ExampleCustomRepositoryImpl implements ExampleCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Example> findExamplesByTitle(String title) {
        return jpaQueryFactory.selectFrom(example)
                .where(
                        example.exampleTitle.like("%" + title + "%")
                )
                .orderBy(example.exampleId.asc())
                .fetch();
    }
}
