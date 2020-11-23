package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.ogedik.commons.constants.Headers;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.rest.response.model.WorklogContainer;

@FeignClient(name = Services.TIME_TRACKER)
public interface TimeTrackerProxy {

    @GetMapping("/tracker" + Services.Path.WORKLOGS)
    WorklogContainer getWorklogs(
            @RequestHeader(value = Headers.AUTH_USER) String authenticatedUsername,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam String isUserOnly);

}
