package phonelostservice.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phonelostservice.config.kafka.KafkaProcessor;
import phonelostservice.domain.*;

@Service
public class InqurySelfPhoneViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private InqurySelfPhoneRepository inqurySelfPhoneRepository;
    //>>> DDD / CQRS
}
