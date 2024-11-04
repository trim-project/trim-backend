package com.trim.domain.member.entity;

import com.trim.domain.question.entity.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "member")
    private List<Question> questionList = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Scrap> scrapList = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<AnswerLike> answerLikeList = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Badge> badgeList = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "avatar_id")
//    private Avatar avatar;

}
