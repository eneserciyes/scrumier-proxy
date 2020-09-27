package authentication;

import org.springframework.cloud.openfeign.FeignClient;
import tr.com.ogedik.commons.constants.Services;

/**
 * @author orkungedik
 */
@FeignClient(name = Services.AUTHENTICATION)
public class GroupProxy {
}
