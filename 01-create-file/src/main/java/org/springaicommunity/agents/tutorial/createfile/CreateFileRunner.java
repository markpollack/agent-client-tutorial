package org.springaicommunity.agents.tutorial.createfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.agents.client.AgentClient;
import org.springaicommunity.agents.client.AgentClientResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Tutorial 01: Create a file using whichever agent provider is on the classpath.
 *
 * This uses only the portable AgentClient.Builder API. The provider is selected by the
 * Maven profile (claude, codex, or gemini) which controls which starter JAR is on the
 * classpath. Spring Boot auto-configuration does the rest.
 */
@Component
public class CreateFileRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CreateFileRunner.class);

	private final AgentClient.Builder agentClientBuilder;

	public CreateFileRunner(AgentClient.Builder agentClientBuilder) {
		this.agentClientBuilder = agentClientBuilder;
	}

	@Override
	public void run(String... args) {
		log.info("Starting Spring Agent demo...");

		Path workingDir = Path.of(System.getProperty("user.dir"));
		String goal = "Create a file named hello.txt with the content 'Hello from Spring AI Agent Client!'";

		log.info("Working directory: {}", workingDir);
		log.info("Executing goal: {}", goal);

		// Clean up from previous runs
		Path targetFile = workingDir.resolve("hello.txt");
		try {
			if (Files.deleteIfExists(targetFile)) {
				log.info("Cleaned up hello.txt from previous run");
			}
		}
		catch (IOException e) {
			log.warn("Could not delete existing hello.txt: {}", e.getMessage());
		}

		AgentClient agentClient = agentClientBuilder.defaultWorkingDirectory(workingDir).build();
		AgentClientResponse response = agentClient.run(goal);

		if (response.isSuccessful()) {
			log.info("Goal completed successfully!");

			if (Files.exists(targetFile)) {
				try {
					String content = Files.readString(targetFile);
					log.info("Verified: hello.txt contains: {}", content.trim());
				}
				catch (IOException e) {
					log.warn("Could not read hello.txt: {}", e.getMessage());
				}
			}
		}
		else {
			log.error("Goal execution failed: {}", response.getResult());
		}
	}

}
