package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRankingHistory is a Querydsl query type for RankingHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRankingHistory extends EntityPathBase<RankingHistory> {

    private static final long serialVersionUID = 2062825384L;

    public static final QRankingHistory rankingHistory = new QRankingHistory("rankingHistory");

    public final NumberPath<Integer> ranking = createNumber("ranking", Integer.class);

    public final NumberPath<Integer> rankingHistoryId = createNumber("rankingHistoryId", Integer.class);

    public final StringPath team = createString("team");

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QRankingHistory(String variable) {
        super(RankingHistory.class, forVariable(variable));
    }

    public QRankingHistory(Path<? extends RankingHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRankingHistory(PathMetadata metadata) {
        super(RankingHistory.class, metadata);
    }

}

