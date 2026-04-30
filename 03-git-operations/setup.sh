#!/bin/bash
# Sets up a git repo with "lost" changes on a detached HEAD.
# Run this before the tutorial example.

set -e

WORKSPACE="workspace"

rm -rf "$WORKSPACE"
mkdir -p "$WORKSPACE"
cd "$WORKSPACE"

git init -q
git config user.email "test@example.com"
git config user.name "Test User"

# Initial commit on master
echo "<html><body>Welcome to my site</body></html>" > index.html
git add -A && git commit -q -m "Initial site"

# Make changes on a detached HEAD (simulating "lost" work)
echo "<html><body>I moved to Stanford!</body></html>" > index.html
echo "# About Me - Stanford" > about.md
git add -A && git commit -q -m "Move to Stanford"

# Go back to master — changes are "lost" on detached commit
git checkout -q master

echo "Setup complete. The 'Move to Stanford' commit is on a detached HEAD."
echo "Run: mvn spring-boot:run"
