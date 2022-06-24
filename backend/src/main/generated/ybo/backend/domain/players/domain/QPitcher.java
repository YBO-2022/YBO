package ybo.backend.domain.players.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPitcher is a Querydsl query type for Pitcher
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPitcher extends EntityPathBase<Pitcher> {

    private static final long serialVersionUID = -1894346361L;

    public static final QPitcher pitcher = new QPitcher("pitcher");

    public final NumberPath<Integer> bb = createNumber("bb", Integer.class);

    public final NumberPath<Integer> earnedRun = createNumber("earnedRun", Integer.class);

    public final NumberPath<Float> era = createNumber("era", Float.class);

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Integer> homerun = createNumber("homerun", Integer.class);

    public final NumberPath<Float> inning = createNumber("inning", Float.class);

    public final NumberPath<Integer> lose = createNumber("lose", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> runs = createNumber("runs", Integer.class);

    public final NumberPath<Integer> strikeout = createNumber("strikeout", Integer.class);

    public final StringPath team = createString("team");

    public final NumberPath<Float> war = createNumber("war", Float.class);

    public final NumberPath<Integer> win = createNumber("win", Integer.class);

    public QPitcher(String variable) {
        super(Pitcher.class, forVariable(variable));
    }

    public QPitcher(Path<? extends Pitcher> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPitcher(PathMetadata metadata) {
        super(Pitcher.class, metadata);
    }

}

