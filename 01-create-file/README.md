# Tutorial 01: Create a File

The simplest possible AgentClient task — create a file — demonstrated with all three providers.

## What This Example Shows

- Spring Boot auto-configuration selects the agent provider based on classpath
- Portable `AgentClient.Builder` API works identically across providers
- No provider-specific imports in Java code

## Running

```bash
# Claude (default)
./mvnw spring-boot:run -pl 01-create-file

# Codex
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=codex

# Gemini
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=gemini
```

## Expected Output

```
: Starting Spring Agent demo...
: Working directory: /path/to/01-create-file
: Executing goal: Create a file named hello.txt with the content 'Hello from Spring AI Agent Client!'
: Goal completed successfully!
: Verified: hello.txt contains: Hello from Spring AI Agent Client!
```

## Configuration

See the profile-specific YAML files in `src/main/resources/`:
- `application-claude.yml` — Claude Code settings
- `application-codex.yml` — Codex settings
- `application-gemini.yml` — Gemini settings

For more on how defaults work across providers, see [Defaults Philosophy](https://springaicommunity.mintlify.app/agent-client/defaults-philosophy).
