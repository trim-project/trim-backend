package com.trim.domain.member.entity;

import com.trim.domain.auditing.entity.BaseTimeEntity;
import com.trim.domain.question.entity.Question;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

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


}
