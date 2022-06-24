package ybo.backend.domain.goldenglove.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEraPredict is a Querydsl query type for EraPredict
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEraPredict extends EntityPathBase<EraPredict> {

    private static final long serialVersionUID = -714034999L;

    public static final QEraPredict eraPredict = new QEraPredict("eraPredict");

    public final NumberPath<Float> era = createNumber("era", Float.class);

    public final StringPath name = createString("name");

    public final NumberPath<Float> predictEra = createNumber("predictEra", Float.class);

    public final StringPath team = createString("team");

    public QEraPredict(String variable) {
        super(EraPredict.class, forVariable(variable));
    }

    public QEraPredict(Path<? extends EraPredict> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEraPredict(PathMetadata metadata) {
        super(EraPredict.class, metadata);
    }

}

