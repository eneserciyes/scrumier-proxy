package tr.com.ogedik.scrumier.proxy.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.model.BusinessObject;
import tr.com.ogedik.commons.rest.request.model.JiraConfigurationProperties;
import tr.com.ogedik.commons.rest.response.AbstractResponse;

import java.util.List;

/**
 * @author orkungedik
 */
@FeignClient(name = Services.CONFIGURATION)
public interface ConfigurationProxy {

    /**
     * Returns the Jira instance properties. If properties are not configured, it returns default values.
     *
     * @return {@link AbstractResponse} that contains Jira configuration properties
     */
    @GetMapping(Services.Path.JIRA)
    JiraConfigurationProperties getJiraInstanceConfig();

    /**
     * Returns the mail server instance properties. If properties are not configured, it returns default values.
     *
     * @return {@link AbstractResponse} that contains mail server configuration properties
     */
    @GetMapping(Services.Path.MAIL)
    AbstractResponse getMailServerConfig();

    /**
     * Inserts a property to persistence by key if it is one of the acceptable property key.
     *
     * @param property to be inserted property
     * @return {@link AbstractResponse} that contains inserted property result
     */
    @PostMapping
    AbstractResponse configureProperty(BusinessObject property);

    /**
     * Inserts the all setup configuration on initialization of the Scrumier
     *
     * @param configurationProperties to be insterted proeprties
     * @return {@link AbstractResponse} that contains inserted property result
     */
    @PostMapping(Services.Path.SETUP)
    AbstractResponse setUp(@RequestBody List<BusinessObject> configurationProperties);
}
