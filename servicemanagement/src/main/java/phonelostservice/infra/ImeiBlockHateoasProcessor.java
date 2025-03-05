package phonelostservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonelostservice.domain.*;

@Component
public class ImeiBlockHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ImeiBlock>> {

    @Override
    public EntityModel<ImeiBlock> process(EntityModel<ImeiBlock> model) {
        return model;
    }
}
