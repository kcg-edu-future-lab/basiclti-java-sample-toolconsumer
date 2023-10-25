package edu.kcg.futurelab.sample.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.imsglobal.lti.launch.LtiOauthSigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kcg.futurelab.sample.springboot.config.application.ToolsConfig;
import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/go")
public class GoController {
	@GetMapping()
	public String go(Model model, @RequestParam String name) throws Throwable{
        var c = configs.get(name);

        var parameters = new HashMap<String, String>(){{
            put("user_id", "userId");
            put("context_id", "contextId");
            put("user_name", "userName");
            put("lis_person_sourcedid", "USERID");
            put("lis_person_name_full", "LTIテスト");
        }};
        var signer = new LtiOauthSigner();
        var signedParameters = signer.signParameters(
            parameters, c.getKey(), c.getSecret(), c.getUrl(), "POST");
        model.addAttribute("url", c.getUrl());
        model.addAttribute("params", signedParameters);
        return "go";
	}

    @PostConstruct
    private void init(){
        for(var c : toolsConfig.getTools()){
            configs.put(c.getName(), c);
        }
    }

    @Autowired
    private ToolsConfig toolsConfig;
    private Map<String, ToolsConfig.Tool> configs = new HashMap<>();
}
