package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSeasonHighLow is a Querydsl query type for SeasonHighLow
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSeasonHighLow extends EntityPathBase<SeasonHighLow> {

    private static final long serialVersionUID = 318786693L;

    public static final QSeasonHighLow seasonHighLow = new QSeasonHighLow("seasonHighLow");

    public final NumberPath<Integer> seasonHigh = createNumber("seasonHigh", Integer.class);

    public final NumberPath<Integer> seasonLow = createNumber("seasonLow", Integer.class);

    public final StringPath team = createString("team");

    public QSeasonHighLow(String variable) {
        super(SeasonHighLow.class, forVariable(variable));
    }

    public QSeasonHighLow(Path<? extends SeasonHighLow> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSeasonHighLow(PathMetadata metadata) {
        super(SeasonHighLow.class, metadata);
    }

}

