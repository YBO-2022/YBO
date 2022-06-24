package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRankPredict is a Querydsl query type for RankPredict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRankPredict extends EntityPathBase<RankPredict> {

    private static final long serialVersionUID = -2093504733L;

    public static final QRankPredict rankPredict = new QRankPredict("rankPredict");

    public final NumberPath<Float> predictWinRate = createNumber("predictWinRate", Float.class);

    public final NumberPath<Integer> rankPredictId = createNumber("rankPredictId", Integer.class);

    public final StringPath team = createString("team");

    public final NumberPath<Float> winRate = createNumber("winRate", Float.class);

    public QRankPredict(String variable) {
        super(RankPredict.class, forVariable(variable));
    }

    public QRankPredict(Path<? extends RankPredict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRankPredict(PathMetadata metadata) {
        super(RankPredict.class, metadata);
    }

}

