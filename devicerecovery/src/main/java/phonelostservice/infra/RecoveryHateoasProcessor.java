package phonelostservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonelostservice.domain.*;

@Component
public class RecoveryHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Recovery>> {

    @Override
    public EntityModel<Recovery> process(EntityModel<Recovery> model) {
        return model;
    }
}
