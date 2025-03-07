package phonelostservice.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "servicemanagement", url = "${api.url.servicemanagement}")
public interface ImeiBlockService {
    @RequestMapping(method = RequestMethod.POST, path = "/imeiBlocks")
    public void requestImeiBlocked(@RequestBody ImeiBlock imeiBlock);

    @RequestMapping(method = RequestMethod.POST, path = "/imeiBlocks")
    public void requestImeiUnblock(@RequestBody ImeiBlock imeiBlock);
}
