package com.trim.domain.question.entity;

import com.trim.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Entity
@Getter
@NoArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer;

    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

//    @OneToMany(mappedBy = "question")
//    private List<Scrap> scrapList = new ArrayList<>();

//    @OneToMany(mappedBy = "question")
//    private List<QuestionComment> questionCommentList = new ArrayList<>();

//    @OneToMany(mappedBy = "question")
//    private List<Tag> tagList = new ArrayList<>();

//    @OneToMany(mappedBy = "question")
//    private List<Answer> answerList = new ArrayList<>();

}
