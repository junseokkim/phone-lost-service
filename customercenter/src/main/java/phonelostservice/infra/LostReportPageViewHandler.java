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
public class LostReportPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private LostReportPageRepository lostReportPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLostReportReceived_then_CREATE_1(
        @Payload LostReportReceived lostReportReceived
    ) {
        try {
            if (!lostReportReceived.validate()) return;

            // view 객체 생성
            LostReportPage lostReportPage = new LostReportPage();
            // view 객체에 이벤트의 Value 를 set 함
            lostReportPage.setLostReportId(lostReportReceived.getId());
            lostReportPage.setDeviceId(lostReportReceived.getDeviceId());
            lostReportPage.setLostReportStatus("분실 접수됨");
            // view 레파지 토리에 save
            lostReportPageRepository.save(lostReportPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeviceStatusChangedToLost_then_UPDATE_1(
        @Payload DeviceStatusChangedToLost deviceStatusChangedToLost
    ) {
        try {
            if (!deviceStatusChangedToLost.validate()) return;
            // view 객체 조회

            List<LostReportPage> lostReportPageList = lostReportPageRepository.findByDeviceId(
                deviceStatusChangedToLost.getId()
            );
            for (LostReportPage lostReportPage : lostReportPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                lostReportPage.setLostReportStatus("분실");
                // view 레파지 토리에 save
                lostReportPageRepository.save(lostReportPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
