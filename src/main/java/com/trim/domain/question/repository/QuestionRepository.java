package com.trim.domain.question.repository;

import com.trim.domain.member.entity.Member;
import com.trim.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long>{
    List<Question> findByWriter(Member writer);
}
