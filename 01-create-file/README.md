# Tutorial 01: Create a File

The simplest possible AgentClient task — create a file — demonstrated with all three providers.

**Full lesson: [lab.pollack.ai/docs/agent-client/tutorial/01-first-task](https://lab.pollack.ai/docs/agent-client/tutorial/01-first-task)**

## Run

```bash
# Claude (default)
./mvnw spring-boot:run -pl 01-create-file

# Codex
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=codex

# Gemini
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=gemini
```

## Verify

```bash
cat hello.txt
# Hello from Spring AI Agent Client!
```

## What This Shows

- Spring Boot auto-configuration selects the provider based on classpath
- Portable `AgentClient.Builder` API works identically across providers
- No provider-specific imports in application code

See `src/main/resources/application-*.yml` for provider-specific configuration.
