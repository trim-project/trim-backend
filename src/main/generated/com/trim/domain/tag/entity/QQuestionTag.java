package com.trim.domain.tag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionTag is a Querydsl query type for QuestionTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionTag extends EntityPathBase<QuestionTag> {

    private static final long serialVersionUID = 2067389992L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionTag questionTag = new QQuestionTag("questionTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.trim.domain.question.entity.QQuestion question;

    public final QTag tag;

    public QQuestionTag(String variable) {
        this(QuestionTag.class, forVariable(variable), INITS);
    }

    public QQuestionTag(Path<? extends QuestionTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionTag(PathMetadata metadata, PathInits inits) {
        this(QuestionTag.class, metadata, inits);
    }

    public QQuestionTag(Class<? extends QuestionTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new com.trim.domain.question.entity.QQuestion(forProperty("question"), inits.get("question")) : null;
        this.tag = inits.isInitialized("tag") ? new QTag(forProperty("tag")) : null;
    }

}

