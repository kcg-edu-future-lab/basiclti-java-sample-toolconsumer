package edu.kcg.futurelab.sample.springboot.config.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties("")
@Component
@Data
public class ToolsConfig{
	@Data
	public static class Tool{
		private String name;
		private String url;
		private String key;
		private String secret;
	}
	private Tool[] tools;
}