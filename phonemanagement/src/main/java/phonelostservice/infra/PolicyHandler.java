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
    DeviceRepository deviceRepository;

    @Autowired
    RemoteLockRepository remoteLockRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReportReceived'"
    )
    public void wheneverLostReportReceived_ChangeDeviceStatusLost(
        @Payload LostReportReceived lostReportReceived
    ) {
        LostReportReceived event = lostReportReceived;
        System.out.println(
            "\n\n##### listener ChangeDeviceStatusLost : " +
            lostReportReceived +
            "\n\n"
        );

        // Sample Logic //
        Device.changeDeviceStatusLost(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReportCancelled'"
    )
    public void wheneverLostReportCancelled_ChangeDeviceStatusNormal(
        @Payload LostReportCancelled lostReportCancelled
    ) {
        LostReportCancelled event = lostReportCancelled;
        System.out.println(
            "\n\n##### listener ChangeDeviceStatusNormal : " +
            lostReportCancelled +
            "\n\n"
        );

        // Sample Logic //
        Device.changeDeviceStatusNormal(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusChangedToLost'"
    )
    public void wheneverDeviceStatusChangedToLost_RequestRemoteLock(
        @Payload DeviceStatusChangedToLost deviceStatusChangedToLost
    ) {
        DeviceStatusChangedToLost event = deviceStatusChangedToLost;
        System.out.println(
            "\n\n##### listener RequestRemoteLock : " +
            deviceStatusChangedToLost +
            "\n\n"
        );

        // Sample Logic //
        RemoteLock.requestRemoteLock(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='DeviceStatusChangedToNormal'"
    )
    public void wheneverDeviceStatusChangedToNormal_RequestRemoteUnlock(
        @Payload DeviceStatusChangedToNormal deviceStatusChangedToNormal
    ) {
        DeviceStatusChangedToNormal event = deviceStatusChangedToNormal;
        System.out.println(
            "\n\n##### listener RequestRemoteUnlock : " +
            deviceStatusChangedToNormal +
            "\n\n"
        );

        // Sample Logic //
        RemoteLock.requestRemoteUnlock(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
