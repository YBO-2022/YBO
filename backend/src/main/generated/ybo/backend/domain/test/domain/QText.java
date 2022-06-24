package ybo.backend.domain.test.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QText is a Querydsl query type for Text
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QText extends EntityPathBase<Text> {

    private static final long serialVersionUID = -1659649021L;

    public static final QText text = new QText("text");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath value = createString("value");

    public QText(String variable) {
        super(Text.class, forVariable(variable));
    }

    public QText(Path<? extends Text> path) {
        super(path.getType(), path.getMetadata());
    }

    public QText(PathMetadata metadata) {
        super(Text.class, metadata);
    }

}

