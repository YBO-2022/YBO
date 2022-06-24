package ybo.backend.domain.goldenglove.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOpsPredict is a Querydsl query type for OpsPredict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOpsPredict extends EntityPathBase<OpsPredict> {

    private static final long serialVersionUID = -2053413461L;

    public static final QOpsPredict opsPredict = new QOpsPredict("opsPredict");

    public final StringPath name = createString("name");

    public final NumberPath<Float> ops = createNumber("ops", Float.class);

    public final NumberPath<Float> predictOps = createNumber("predictOps", Float.class);

    public final StringPath team = createString("team");

    public QOpsPredict(String variable) {
        super(OpsPredict.class, forVariable(variable));
    }

    public QOpsPredict(Path<? extends OpsPredict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOpsPredict(PathMetadata metadata) {
        super(OpsPredict.class, metadata);
    }

}

