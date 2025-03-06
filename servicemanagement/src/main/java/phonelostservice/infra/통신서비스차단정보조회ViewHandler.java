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
public class 통신서비스차단정보조회ViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private 통신서비스차단정보조회Repository 통신서비스차단정보조회Repository;
    //>>> DDD / CQRS
}
