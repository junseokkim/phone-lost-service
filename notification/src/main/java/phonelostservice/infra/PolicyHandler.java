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
    NotificationRepository notificationRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReportReceived'"
    )
    public void wheneverLostReportReceived_PhoneLostReportAlarm(
        @Payload LostReportReceived lostReportReceived
    ) {
        LostReportReceived event = lostReportReceived;
        System.out.println(
            "\n\n##### listener PhoneLostReportAlarm : " +
            lostReportReceived +
            "\n\n"
        );

        // Sample Logic //
        Notification.phoneLostReportAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LostReportCancelled'"
    )
    public void wheneverLostReportCancelled_PhoneLostReportAlarm(
        @Payload LostReportCancelled lostReportCancelled
    ) {
        LostReportCancelled event = lostReportCancelled;
        System.out.println(
            "\n\n##### listener PhoneLostReportAlarm : " +
            lostReportCancelled +
            "\n\n"
        );

        // Sample Logic //
        Notification.phoneLostReportAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ImeiUnblocked'"
    )
    public void wheneverImeiUnblocked_ImeiBlockedAlarm(
        @Payload ImeiUnblocked imeiUnblocked
    ) {
        ImeiUnblocked event = imeiUnblocked;
        System.out.println(
            "\n\n##### listener ImeiBlockedAlarm : " + imeiUnblocked + "\n\n"
        );

        // Sample Logic //
        Notification.imeiBlockedAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ImeiBlocked'"
    )
    public void wheneverImeiBlocked_ImeiBlockedAlarm(
        @Payload ImeiBlocked imeiBlocked
    ) {
        ImeiBlocked event = imeiBlocked;
        System.out.println(
            "\n\n##### listener ImeiBlockedAlarm : " + imeiBlocked + "\n\n"
        );

        // Sample Logic //
        Notification.imeiBlockedAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PhoneServiceSuspended'"
    )
    public void wheneverPhoneServiceSuspended_PhoneServiceSuspendedAlarm(
        @Payload PhoneServiceSuspended phoneServiceSuspended
    ) {
        PhoneServiceSuspended event = phoneServiceSuspended;
        System.out.println(
            "\n\n##### listener PhoneServiceSuspendedAlarm : " +
            phoneServiceSuspended +
            "\n\n"
        );

        // Sample Logic //
        Notification.phoneServiceSuspendedAlarm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PhoneServiceResumed'"
    )
    public void wheneverPhoneServiceResumed_PhoneServiceSuspendedAlarm(
        @Payload PhoneServiceResumed phoneServiceResumed
    ) {
        PhoneServiceResumed event = phoneServiceResumed;
        System.out.println(
            "\n\n##### listener PhoneServiceSuspendedAlarm : " +
            phoneServiceResumed +
            "\n\n"
        );

        // Sample Logic //
        Notification.phoneServiceSuspendedAlarm(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
