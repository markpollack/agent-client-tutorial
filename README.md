# Agent Client Tutorial

Progressive examples for [Agent Client](https://github.com/markpollack/agent-client) — a portable Java API for autonomous CLI agents (Claude Code, Codex, Gemini).

**Full tutorial with explanations: [lab.pollack.ai/docs/agent-client/tutorial](https://lab.pollack.ai/docs/agent-client/tutorial/index)**

## Quick Start

```bash
git clone https://github.com/markpollack/agent-client-tutorial.git
cd agent-client-tutorial

# Run with Claude (default)
./mvnw spring-boot:run -pl 01-create-file

# Run with Codex
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=codex

# Run with Gemini
./mvnw spring-boot:run -pl 01-create-file -Dspring.profiles.active=gemini
```

## Lessons

| # | Directory | What It Demonstrates | Docs |
|---|-----------|---------------------|------|
| 01 | [create-file](01-create-file/) | Simplest task — create a file with all three providers | [Lesson 1](https://lab.pollack.ai/docs/agent-client/tutorial/01-first-task) |
| 02 | [read-and-transform](02-read-and-transform/) | Read log files, count severities, write CSV | [Lesson 3](https://lab.pollack.ai/docs/agent-client/tutorial/03-read-and-transform) |
| 03 | [git-operations](03-git-operations/) | Find lost commits, merge into master | [Lesson 4](https://lab.pollack.ai/docs/agent-client/tutorial/04-git-operations) |

## Prerequisites

- Java 17+
- At least one CLI agent installed and authenticated:

| Provider | Install | Auth |
|----------|---------|------|
| Claude Code | `npm install -g @anthropic-ai/claude-code` | `claude auth login` |
| OpenAI Codex | `npm install -g @openai/codex` | Set `OPENAI_API_KEY` |
| Gemini CLI | `npm install -g @google/gemini-cli` | Set `GOOGLE_API_KEY` |

## Documentation

- [Tutorial (full walkthrough)](https://lab.pollack.ai/docs/agent-client/tutorial/index)
- [Getting Started](https://lab.pollack.ai/docs/agent-client/howto/getting-started)
- [Agent Client Overview](https://lab.pollack.ai/projects/agent-client)
- [Configuration Reference](https://lab.pollack.ai/docs/agent-client/reference/portable-options)
