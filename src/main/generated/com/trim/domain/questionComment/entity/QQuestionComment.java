package com.trim.domain.questionComment.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionComment is a Querydsl query type for QuestionComment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionComment extends EntityPathBase<QuestionComment> {

    private static final long serialVersionUID = 1169318542L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionComment questionComment = new QQuestionComment("questionComment");

    public final com.trim.domain.auditing.entity.QBaseTimeEntity _super = new com.trim.domain.auditing.entity.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final com.trim.domain.question.entity.QQuestion question;

    public final com.trim.domain.member.entity.QMember writer;

    public QQuestionComment(String variable) {
        this(QuestionComment.class, forVariable(variable), INITS);
    }

    public QQuestionComment(Path<? extends QuestionComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionComment(PathMetadata metadata, PathInits inits) {
        this(QuestionComment.class, metadata, inits);
    }

    public QQuestionComment(Class<? extends QuestionComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new com.trim.domain.question.entity.QQuestion(forProperty("question"), inits.get("question")) : null;
        this.writer = inits.isInitialized("writer") ? new com.trim.domain.member.entity.QMember(forProperty("writer")) : null;
    }

}

