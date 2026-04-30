package org.springaicommunity.agents.tutorial.readtransform;

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
 * Tutorial 02: Read log files, count severity levels, write a summary CSV.
 *
 * Demonstrates an agent reading existing files, performing data transformation,
 * and writing structured output. Uses only the portable AgentClient API.
 */
@Component
public class ReadTransformRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(ReadTransformRunner.class);

	private final AgentClient.Builder agentClientBuilder;

	public ReadTransformRunner(AgentClient.Builder agentClientBuilder) {
		this.agentClientBuilder = agentClientBuilder;
	}

	@Override
	public void run(String... args) throws IOException {
		Path workingDir = Path.of(System.getProperty("user.dir"));
		Path logsDir = workingDir.resolve("logs");

		// Create sample log files if they don't exist
		if (!Files.exists(logsDir)) {
			log.info("Creating sample log files in {}", logsDir);
			createSampleLogs(logsDir);
		}

		String goal = """
				In the logs/ directory there are multiple .log files from different services.
				Scan all .log files and count how many lines contain "ERROR", "WARNING", and "INFO".

				Output your results to summary.csv with the following structure:
				severity,count
				ERROR,<total ERROR lines>
				WARNING,<total WARNING lines>
				INFO,<total INFO lines>

				The output should be a valid CSV file with exactly four lines.""";

		log.info("Working directory: {}", workingDir);
		log.info("Executing goal: read and summarize log files");

		AgentClient agentClient = agentClientBuilder.defaultWorkingDirectory(workingDir).build();
		AgentClientResponse response = agentClient.run(goal);

		if (response.isSuccessful()) {
			log.info("Goal completed successfully!");

			Path summaryFile = workingDir.resolve("summary.csv");
			if (Files.exists(summaryFile)) {
				String content = Files.readString(summaryFile);
				log.info("summary.csv contents:\n{}", content);
			}
		}
		else {
			log.error("Goal execution failed: {}", response.getResult());
		}
	}

	private void createSampleLogs(Path logsDir) throws IOException {
		Files.createDirectories(logsDir);

		Files.writeString(logsDir.resolve("auth.log"), """
				2026-04-29 08:01:00 INFO User login successful
				2026-04-29 08:02:00 ERROR Failed to validate token
				2026-04-29 08:03:00 WARNING Session expiring soon
				2026-04-29 08:04:00 INFO Password changed
				2026-04-29 08:05:00 ERROR Database connection timeout
				""");

		Files.writeString(logsDir.resolve("api.log"), """
				2026-04-29 09:01:00 INFO Request received GET /users
				2026-04-29 09:02:00 WARNING Rate limit approaching
				2026-04-29 09:03:00 ERROR Internal server error
				2026-04-29 09:04:00 INFO Request received POST /orders
				2026-04-29 09:05:00 WARNING Deprecated endpoint called
				2026-04-29 09:06:00 INFO Health check passed
				""");

		Files.writeString(logsDir.resolve("worker.log"), """
				2026-04-29 10:01:00 INFO Job started: batch-001
				2026-04-29 10:02:00 ERROR Out of memory
				2026-04-29 10:03:00 WARNING Disk space low
				2026-04-29 10:04:00 INFO Job completed: batch-001
				""");
	}

}
