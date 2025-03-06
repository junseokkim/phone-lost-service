package phonelostservice.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import phonelostservice.config.kafka.KafkaProcessor;
import phonelostservice.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ImeiBlockRepository imeiBlockRepository;

    @Autowired
    UsimBlockRepository usimBlockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusChangedToLost'"
    )
    public void wheneverDeviceStatusChangedToLost_BlockOnLost(
        @Payload DeviceStatusChangedToLost deviceStatusChangedToLost
    ) {
        DeviceStatusChangedToLost event = deviceStatusChangedToLost;
        System.out.println(
            "\n\n##### listener BlockOnLost : " +
            deviceStatusChangedToLost +
            "\n\n"
        );

        // Sample Logic //
        ImeiBlock.blockOnLost(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusChangedToNormal'"
    )
    public void wheneverDeviceStatusChangedToNormal_BlockOnNormal(
        @Payload DeviceStatusChangedToNormal deviceStatusChangedToNormal
    ) {
        DeviceStatusChangedToNormal event = deviceStatusChangedToNormal;
        System.out.println(
            "\n\n##### listener BlockOnNormal : " +
            deviceStatusChangedToNormal +
            "\n\n"
        );

        // Sample Logic //
        ImeiBlock.blockOnNormal(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
