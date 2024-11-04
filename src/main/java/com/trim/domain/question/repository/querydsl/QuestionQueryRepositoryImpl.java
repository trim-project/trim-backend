package com.trim.domain.question.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class QuestionQueryRepositoryImpl implements QuestionQueryRepository{
    private final JPAQueryFactory queryFactory;

    //여기에 검색 repository 구현

}
