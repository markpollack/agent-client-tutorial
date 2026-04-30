package org.springaicommunity.agents.tutorial.gitops;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.agents.client.AgentClient;
import org.springaicommunity.agents.client.AgentClientResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Tutorial 03: Git operations — find lost changes and merge them.
 *
 * This example works in a git repository, demonstrating tasks where
 * STRICT mode (requiring a git repo) is appropriate. The agent uses
 * git commands to inspect history, find detached commits, and merge.
 *
 * Setup: Run setup.sh first to create a git repo with "lost" changes
 * on a detached HEAD.
 */
@Component
public class GitOpsRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(GitOpsRunner.class);

	private final AgentClient.Builder agentClientBuilder;

	public GitOpsRunner(AgentClient.Builder agentClientBuilder) {
		this.agentClientBuilder = agentClientBuilder;
	}

	@Override
	public void run(String... args) {
		Path workingDir = Path.of(System.getProperty("user.dir")).resolve("workspace");

		if (!workingDir.resolve(".git").toFile().exists()) {
			log.error("No git repository found at {}. Run setup.sh first.", workingDir);
			log.info("Usage: cd 03-git-operations && bash setup.sh && mvn spring-boot:run");
			return;
		}

		String goal = """
				I just made some changes to my personal site and checked out master,
				but now I can't find those changes. Please help me find them and
				merge them into master.""";

		log.info("Working directory: {}", workingDir);
		log.info("Executing goal: find and merge lost git changes");

		AgentClient agentClient = agentClientBuilder.defaultWorkingDirectory(workingDir).build();
		AgentClientResponse response = agentClient.run(goal);

		if (response.isSuccessful()) {
			log.info("Goal completed successfully!");
			log.info("Agent response: {}", response.getResult());
		}
		else {
			log.error("Goal execution failed: {}", response.getResult());
		}
	}

}
