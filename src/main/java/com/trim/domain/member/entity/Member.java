package com.trim.domain.member.entity;

import com.trim.domain.auditing.entity.BaseTimeEntity;
import com.trim.domain.question.entity.Question;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Getter
@SuperBuilder
@Table(name = "member", indexes = @Index(name = "idx_username", columnList = "username"))
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, unique = true)
    private String username;

    private String nickname;

    @OneToMany(mappedBy = "writer")
    private List<Question> questionList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role.getKey()));
    }

    @Override
    public String getPassword() {
        return null;        //해당 항목 없음
    }

    @PrePersist
    public void generateUsername() {
        if (this.username == null || this.username.isEmpty()) {
            this.username = UUID.randomUUID().toString();
        }
    }

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
