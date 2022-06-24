package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFirstTeam is a Querydsl query type for FirstTeam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFirstTeam extends EntityPathBase<FirstTeam> {

    private static final long serialVersionUID = -2140918077L;

    public static final QFirstTeam firstTeam = new QFirstTeam("firstTeam");

    public final StringPath C = createString("C");

    public final StringPath CF = createString("CF");

    public final StringPath DH = createString("DH");

    public final StringPath FB = createString("FB");

    public final StringPath LF = createString("LF");

    public final StringPath P = createString("P");

    public final StringPath RF = createString("RF");

    public final StringPath SB = createString("SB");

    public final StringPath SS = createString("SS");

    public final StringPath TB = createString("TB");

    public final StringPath team = createString("team");

    public QFirstTeam(String variable) {
        super(FirstTeam.class, forVariable(variable));
    }

    public QFirstTeam(Path<? extends FirstTeam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFirstTeam(PathMetadata metadata) {
        super(FirstTeam.class, metadata);
    }

}

