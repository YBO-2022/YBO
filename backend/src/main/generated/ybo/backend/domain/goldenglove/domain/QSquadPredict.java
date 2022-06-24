package ybo.backend.domain.goldenglove.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSquadPredict is a Querydsl query type for SquadPredict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSquadPredict extends EntityPathBase<SquadPredict> {

    private static final long serialVersionUID = 328905251L;

    public static final QSquadPredict squadPredict = new QSquadPredict("squadPredict");

    public final StringPath name = createString("name");

    public final StringPath position = createString("position");

    public final StringPath team = createString("team");

    public QSquadPredict(String variable) {
        super(SquadPredict.class, forVariable(variable));
    }

    public QSquadPredict(Path<? extends SquadPredict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSquadPredict(PathMetadata metadata) {
        super(SquadPredict.class, metadata);
    }

}

