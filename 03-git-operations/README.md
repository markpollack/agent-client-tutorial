# Tutorial 03: Git Operations

Find lost commits on a detached HEAD and merge them into master.

**Full lesson: [lab.pollack.ai/docs/agent-client/tutorial/04-git-operations](https://lab.pollack.ai/docs/agent-client/tutorial/04-git-operations)**

## Setup

Run the setup script first — it creates a git repo with "lost" changes:

```bash
cd 03-git-operations
bash setup.sh
```

## Run

```bash
./mvnw spring-boot:run
```

## Verify

```bash
cd workspace
git log --oneline -5
# Should show recovered changes merged into master
```

## What This Shows

- Agent working in an existing git repository
- Multi-step reasoning — inspect reflog, identify lost commits, merge
- Tool-heavy task — multiple shell commands with decision-making
- When STRICT mode (requiring git repo) is appropriate
