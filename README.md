# Agent Client Tutorial

Progressive examples for the [Spring AI Agent Client](https://github.com/spring-ai-community/agent-client) — a portable abstraction for agentic CLI tools (Claude Code, OpenAI Codex, Gemini CLI).

## Examples

| # | Example | What It Demonstrates |
|---|---------|---------------------|
| 01 | [create-file](01-create-file/) | Simplest task — create a file — with all three providers |

## Quick Start

```bash
git clone https://github.com/spring-ai-community/agent-client-tutorial.git
cd agent-client-tutorial

# Run with Claude (default)
./mvnw spring-boot:run -pl 01-create-file

# Run with Codex
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=codex

# Run with Gemini
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=gemini
```

## Prerequisites

- Java 17+
- At least one agentic CLI installed and authenticated:

| Provider | Install | Auth |
|----------|---------|------|
| Claude Code | `npm install -g @anthropic-ai/claude-code` | `claude auth login` |
| OpenAI Codex | `npm install -g @openai/codex` | Set `OPENAI_API_KEY` |
| Gemini CLI | `npm install -g @anthropic-ai/gemini-cli` | Set `GOOGLE_API_KEY` |

## Documentation

- [Agent Client Overview](https://springaicommunity.mintlify.app/projects/incubating/agent-client)
- [Defaults Philosophy (LOOSE/STRICT)](https://springaicommunity.mintlify.app/agent-client/defaults-philosophy)
- [Agent Sessions](https://springaicommunity.mintlify.app/agent-client/sessions)
