package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.model.JiraUser;
import tr.com.ogedik.commons.rest.request.model.AuthenticationRequest;
import tr.com.ogedik.commons.rest.request.model.CreateUpdateWorklogRequest;
import tr.com.ogedik.commons.rest.request.model.JiraConfigurationProperties;
import tr.com.ogedik.commons.rest.request.model.sessions.JiraSession;
import tr.com.ogedik.commons.rest.response.BoardsResponse;
import tr.com.ogedik.commons.rest.response.SprintResponse;
import tr.com.ogedik.commons.rest.response.model.JQLSearchResult;

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
    JQLSearchResult getIssuesWithWorklogs(@RequestParam(name = "username") String username,
                                          @RequestParam(name = "startDate") String startDate,
                                          @RequestParam(name = "endDate") String endDate);

    @PostMapping(Services.Path.WORKLOG)
    Boolean createNewWorklog(@RequestBody CreateUpdateWorklogRequest createWorklogRequest);

    @PutMapping(Services.Path.WORKLOG)
    Boolean updateWorklog(@RequestBody CreateUpdateWorklogRequest updateWorklogRequest);

    @GetMapping(Services.Path.ISSUES_IN_SPRINT)
    JQLSearchResult getIssuesInASprint(@RequestParam(name = "sprintCode") String sprintCode, @RequestParam(name="fields") String fields);

    @GetMapping(Services.Path.BOARDS)
    BoardsResponse getAllBoards();

    @GetMapping(Services.Path.SPRINTS)
    SprintResponse getSprintsInABoard(@RequestParam String boardId);

    @GetMapping(Services.Path.ISSUES)
    JQLSearchResult getRecentIssues();
}
