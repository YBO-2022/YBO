package ybo.backend.domain.realtime.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRealtimeGame is a Querydsl query type for RealtimeGame
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRealtimeGame extends EntityPathBase<RealtimeGame> {

    private static final long serialVersionUID = -1772177620L;

    public static final QRealtimeGame realtimeGame = new QRealtimeGame("realtimeGame");

    public final StringPath gameState = createString("gameState");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath leftPitcher = createString("leftPitcher");

    public final StringPath leftScore = createString("leftScore");

    public final StringPath leftTeam = createString("leftTeam");

    public final StringPath rightPitcher = createString("rightPitcher");

    public final StringPath rightScore = createString("rightScore");

    public final StringPath rightTeam = createString("rightTeam");

    public final StringPath state = createString("state");

    public QRealtimeGame(String variable) {
        super(RealtimeGame.class, forVariable(variable));
    }

    public QRealtimeGame(Path<? extends RealtimeGame> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRealtimeGame(PathMetadata metadata) {
        super(RealtimeGame.class, metadata);
    }

}

