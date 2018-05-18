package org.gluu.oidc.rpserver.controller.rp;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.gluu.oidc.rpserver.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController extends BaseController {
    @RequestMapping(path = "{client_id}/{test_id}/registration", method = RequestMethod.POST)
    public void register(
    		@PathVariable("client_id") String clientId,
    		@PathVariable("test_id") String testId,
    		@RequestBody Map<String, Object> params,
    		HttpServletResponse response) {

    }
}
