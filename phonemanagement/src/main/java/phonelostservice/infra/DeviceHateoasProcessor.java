package phonelostservice.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import phonelostservice.domain.*;

@Component
public class DeviceHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Device>> {

    @Override
    public EntityModel<Device> process(EntityModel<Device> model) {
        return model;
    }
}
