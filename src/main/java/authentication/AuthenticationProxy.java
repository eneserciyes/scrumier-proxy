package authentication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tr.com.ogedik.commons.constants.Services;
import tr.com.ogedik.commons.model.BusinessObject;
import tr.com.ogedik.commons.rest.request.model.AuthenticationRequest;
import tr.com.ogedik.commons.rest.response.AbstractResponse;

/**
 * @author orkungedik
 */
@FeignClient(name = Services.AUTHENTICATION)
public interface AuthenticationProxy {

    @PostMapping(Services.AUTHENTICATION + Services.Path.AUTHENTICATE)
    AbstractResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest);

    @PostMapping(Services.AUTHENTICATION + Services.Path.VALIDATE)
    AbstractResponse validate(@RequestBody String token);

    @GetMapping(Services.AUTHENTICATION + Services.Path.PERMISSIONS)
    AbstractResponse getPermissions();

    @GetMapping(Services.AUTHENTICATION + Services.Path.USERS)
    AbstractResponse getUsers();

    @GetMapping(Services.AUTHENTICATION + Services.Path.USERS + Services.Path.IDENTIFIER)
    AbstractResponse getUser(@PathVariable String identifier);

    @PostMapping(Services.AUTHENTICATION + Services.Path.USERS)
    AbstractResponse createUser(@RequestBody BusinessObject authenticationUseR);

    @PutMapping(Services.AUTHENTICATION + Services.Path.USERS)
    AbstractResponse updateUser(@RequestBody BusinessObject authenticationUser);

    @DeleteMapping(Services.AUTHENTICATION + Services.Path.USERS + Services.Path.IDENTIFIER)
    AbstractResponse deleteUser(@PathVariable String identifier);

    @GetMapping(Services.AUTHENTICATION + Services.Path.GROUPS)
    AbstractResponse getGroups();

    @GetMapping(Services.AUTHENTICATION + Services.Path.GROUPS + Services.Path.IDENTIFIER)
    AbstractResponse getGroup(@PathVariable Long identifier);

    @PostMapping(Services.AUTHENTICATION + Services.Path.GROUPS)
    AbstractResponse createGroup(@RequestBody BusinessObject authenticationGroup);

    @PutMapping(Services.AUTHENTICATION + Services.Path.GROUPS)
    AbstractResponse updateGroup(@RequestBody BusinessObject authenticationGroup);

    @DeleteMapping(Services.AUTHENTICATION + Services.Path.GROUPS + Services.Path.IDENTIFIER)
    AbstractResponse deleteGroup(@PathVariable Long identifier);
}
