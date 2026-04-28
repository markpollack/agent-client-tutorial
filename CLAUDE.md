# CLAUDE.md

This repository contains progressive tutorial examples for the Spring AI Agent Client.

## Structure Convention

Examples are numbered directories (`01-create-file/`, `02-read-and-transform/`, etc.) progressing from simple to complex. Each example is a standalone Spring Boot application.

### Adding a New Example

1. Create a numbered directory: `NN-short-name/`
2. Include a `pom.xml` with Maven profiles for each provider (claude, codex, gemini)
3. Use only the portable `AgentClient.Builder` API in Java code — no provider-specific imports
4. Create profile-specific `application-{provider}.yml` files showing provider properties
5. Include a `README.md` explaining what the example demonstrates and how to run it
6. Add the module to the parent `pom.xml`

### Running Examples

```bash
# Default provider (Claude)
./mvnw spring-boot:run -pl 01-create-file

# Specific provider
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=codex
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=gemini
```

### Provider Profiles

Each example supports three Spring profiles:
- `claude` — Claude Code (default, activated when no profile specified)
- `codex` — OpenAI Codex CLI
- `gemini` — Gemini CLI

The Maven profile controls which starter JAR is on the classpath. The Spring profile controls which `application-{provider}.yml` gets loaded.

## Build

```bash
./mvnw clean compile     # Compile all examples
./mvnw clean test        # Run tests (if any)
```

## Dependencies

Examples reference the latest released version of agent-client. Update `agent-client.version` in the parent POM when new releases ship.
