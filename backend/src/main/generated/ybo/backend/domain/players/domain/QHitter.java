package ybo.backend.domain.players.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QHitter is a Querydsl query type for Hitter
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHitter extends EntityPathBase<Hitter> {

    private static final long serialVersionUID = 1649537748L;

    public static final QHitter hitter = new QHitter("hitter");

    public final NumberPath<Float> ba = createNumber("ba", Float.class);

    public final NumberPath<Integer> dp = createNumber("dp", Integer.class);

    public final NumberPath<Integer> games = createNumber("games", Integer.class);

    public final NumberPath<Integer> hit = createNumber("hit", Integer.class);

    public final NumberPath<Integer> hitterId = createNumber("hitterId", Integer.class);

    public final NumberPath<Integer> homerun = createNumber("homerun", Integer.class);

    public final StringPath name = createString("name");

    public final NumberPath<Float> obp = createNumber("obp", Float.class);

    public final NumberPath<Float> ops = createNumber("ops", Float.class);

    public final NumberPath<Integer> pa = createNumber("pa", Integer.class);

    public final NumberPath<Integer> rbi = createNumber("rbi", Integer.class);

    public final NumberPath<Float> slg = createNumber("slg", Float.class);

    public final NumberPath<Integer> steal = createNumber("steal", Integer.class);

    public final NumberPath<Integer> strikeout = createNumber("strikeout", Integer.class);

    public final StringPath team = createString("team");

    public final NumberPath<Float> war = createNumber("war", Float.class);

    public QHitter(String variable) {
        super(Hitter.class, forVariable(variable));
    }

    public QHitter(Path<? extends Hitter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHitter(PathMetadata metadata) {
        super(Hitter.class, metadata);
    }

}

