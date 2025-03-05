package phonelostservice.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "phonemanagement", url = "${api.url.phonemanagement}")
public interface DeviceService {
    @RequestMapping(method = RequestMethod.POST, path = "/devices")
    public void changeDeviceStatusLost(@RequestBody Device device);

    @RequestMapping(method = RequestMethod.POST, path = "/devices")
    public void changeDeviceStatusNormal(@RequestBody Device device);
}
