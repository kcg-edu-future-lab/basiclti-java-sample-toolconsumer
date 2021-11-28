package edu.kcg.futurelab.sample.springboot.controller;

import java.util.HashMap;
import org.imsglobal.lti.launch.LtiOauthSigner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/go")
public class GoController {
    private static String url = "https://fungo.kcg.edu/ltitest/launchweb";
    private static String key = "930bea11-d1b3-c5f6-6629-754d2a47e454";
    private static String secret = "secret";
	@GetMapping()
	public String go(Model model) throws Throwable{
        var parameters = new HashMap<String, String>(){{
            put("user_id", "userId");
            put("context_id", "contextId");
            put("user_name", "userName");
        }};
        var signer = new LtiOauthSigner();
        var signedParameters = signer.signParameters(
            parameters, key, secret, url, "POST");
        model.addAttribute("url", url);
        model.addAttribute("params", signedParameters);
		return "go";
	}
}
