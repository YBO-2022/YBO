package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWarList is a Querydsl query type for WarList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWarList extends EntityPathBase<WarList> {

    private static final long serialVersionUID = 687548092L;

    public static final QWarList warList = new QWarList("warList");

    public final StringPath name = createString("name");

    public final StringPath team = createString("team");

    public final NumberPath<Float> war = createNumber("war", Float.class);

    public QWarList(String variable) {
        super(WarList.class, forVariable(variable));
    }

    public QWarList(Path<? extends WarList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWarList(PathMetadata metadata) {
        super(WarList.class, metadata);
    }

}

