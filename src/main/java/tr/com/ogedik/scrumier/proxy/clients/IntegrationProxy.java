package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.model.JiraUser;
import tr.com.ogedik.commons.rest.request.model.AuthenticationRequest;
import tr.com.ogedik.commons.rest.request.model.CreateWorklogRequest;
import tr.com.ogedik.commons.rest.request.model.JiraConfigurationProperties;
import tr.com.ogedik.commons.rest.request.model.sessions.JiraSession;
import tr.com.ogedik.commons.rest.response.AbstractResponse;

/**
 * @author orkungedik
 */
@FeignClient(name = Services.INTEGRATION)
public interface IntegrationProxy {

    @PostMapping(Services.Path.JIRA_AUTH)
    JiraSession authenticateJira(@RequestBody AuthenticationRequest authenticationRequest);

    @PostMapping(Services.Path.TEST_CONNECTION)
    JiraSession connectJira(@RequestBody JiraConfigurationProperties properties);

    @GetMapping(Services.Path.JIRA_USER)
    JiraUser getJiraUser(@RequestParam(name = "username") String username);

    @GetMapping(Services.Path.LOGGED_ISSUES)
    AbstractResponse getIssuesWithWorklogs(@RequestParam(name = "username") String username,
                                           @RequestParam(name = "startDate") String startDate,
                                           @RequestParam(name = "endDate") String endDate);

    @PostMapping(Services.Path.CREATE_LOG)
    AbstractResponse createNewWorklog(@RequestBody CreateWorklogRequest createWorklogRequest);
}
