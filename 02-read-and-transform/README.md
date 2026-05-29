# Tutorial 02: Read and Transform

Read log files, count severity levels, and write a structured CSV summary.

**Full lesson: [lab.pollack.ai/docs/agent-client/tutorial/03-read-and-transform](https://lab.pollack.ai/docs/agent-client/tutorial/03-read-and-transform)**

## Run

```bash
./mvnw spring-boot:run -pl 02-read-and-transform
```

Sample log files are created automatically on first run.

## Verify

```bash
cat summary.csv
# severity,count
# ERROR,4
# WARNING,4
# INFO,7
```

## What This Shows

- Agent reads existing files (not just creating from scratch)
- Multi-file input — scans a directory of logs
- Structured output — valid CSV with defined schema
- Data transformation — counting, aggregating, formatting
