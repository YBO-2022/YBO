package ybo.backend.domain.realtime.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRealtimeRanking is a Querydsl query type for RealtimeRanking
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRealtimeRanking extends EntityPathBase<RealtimeRanking> {

    private static final long serialVersionUID = -31662404L;

    public static final QRealtimeRanking realtimeRanking = new QRealtimeRanking("realtimeRanking");

    public final StringPath continuity = createString("continuity");

    public final NumberPath<Integer> drawNumber = createNumber("drawNumber", Integer.class);

    public final NumberPath<Float> gameDiff = createNumber("gameDiff", Float.class);

    public final StringPath gameNumber = createString("gameNumber");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> loseNumber = createNumber("loseNumber", Integer.class);

    public final NumberPath<Integer> ranking = createNumber("ranking", Integer.class);

    public final StringPath team = createString("team");

    public final NumberPath<Integer> winNumber = createNumber("winNumber", Integer.class);

    public final NumberPath<Float> winRate = createNumber("winRate", Float.class);

    public QRealtimeRanking(String variable) {
        super(RealtimeRanking.class, forVariable(variable));
    }

    public QRealtimeRanking(Path<? extends RealtimeRanking> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRealtimeRanking(PathMetadata metadata) {
        super(RealtimeRanking.class, metadata);
    }

}

