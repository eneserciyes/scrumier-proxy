package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.rest.request.model.EmailRequest;

@FeignClient(name = Services.NOTIFICATION)
public interface NotificationProxy {

    @PostMapping(Services.Path.MAIL)
    void sendMail(@RequestBody EmailRequest request);
}
