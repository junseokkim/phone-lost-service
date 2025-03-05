package phonelostservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonelostservice.domain.*;

@Component
public class RemoteLockHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<RemoteLock>> {

    @Override
    public EntityModel<RemoteLock> process(EntityModel<RemoteLock> model) {
        return model;
    }
}
