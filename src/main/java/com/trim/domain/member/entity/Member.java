package com.trim.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Column(unique = true)
    private String username;

    private String nickname;

    //스크랩
//    @OneToMany(mappedBy = "member")
//    private List<Scrap> scrapList = new ArrayList<>();

    //질문
//    @OneToMany(mappedBy = "member")
//    private List<Question> questionList = new ArrayList<>();

    //답변 좋아요
//    @OneToMany(mappedBy = "member")
//    private List<AnswerLike> answerLikeList = new ArrayList<>();

    //뱃지
//    @OneToMany(mappedBy = "member")
//    private List<Badge> badgeList = new ArrayList<>();

    //아바타
//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "avatar_id")
//    private Avatar avatar;

}
