package com.trim.domain.question.repository;

import com.trim.domain.question.entity.Question;
import com.trim.domain.question.repository.querydsl.QuestionQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>, QuestionQueryRepository {
}
