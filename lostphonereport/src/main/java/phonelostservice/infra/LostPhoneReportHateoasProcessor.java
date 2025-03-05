package phonelostservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonelostservice.domain.*;

@Component
public class LostPhoneReportHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<LostPhoneReport>> {

    @Override
    public EntityModel<LostPhoneReport> process(
        EntityModel<LostPhoneReport> model
    ) {
        return model;
    }
}
