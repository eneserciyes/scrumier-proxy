package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import tr.com.ogedik.commons.constants.Services;

@FeignClient(name = Services.NOTIFICATION)
public interface NotificationProxy {
}
