package ybo.backend.domain.teams.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVictoryNum is a Querydsl query type for VictoryNum
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVictoryNum extends EntityPathBase<VictoryNum> {

    private static final long serialVersionUID = -392909506L;

    public static final QVictoryNum victoryNum1 = new QVictoryNum("victoryNum1");

    public final StringPath team = createString("team");

    public final NumberPath<Integer> victoryNum = createNumber("victoryNum", Integer.class);

    public QVictoryNum(String variable) {
        super(VictoryNum.class, forVariable(variable));
    }

    public QVictoryNum(Path<? extends VictoryNum> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVictoryNum(PathMetadata metadata) {
        super(VictoryNum.class, metadata);
    }

}

