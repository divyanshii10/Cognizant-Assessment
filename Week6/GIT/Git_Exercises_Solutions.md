# Git Hands-On Exercises Solutions (Week 6)

## Exercise 1: Git Init, Add, Commit
```bash
# 1. Initialize a new repository
mkdir GitDemo
cd GitDemo
git init

# 2. Configure user (Global/Local)
git config user.name "Your Name"
git config user.email "your.email@example.com"
git config --list

# 3. Create a file and add content
echo "Welcome to Git" > welcome.txt

# 4. Check status and add to staging
git status
git add welcome.txt

# 5. Commit the file
git commit -m "Added welcome.txt"

# 6. Push to remote (if applicable)
# git remote add origin <URL>
# git push -u origin master
```

## Exercise 2: Git Ignore
```bash
# 1. Create a log file and a log folder
mkdir log
echo "error log" > app.log
echo "server log" > log/server.log

# 2. Create and update .gitignore
echo "*.log" > .gitignore
echo "log/" >> .gitignore

# 3. Verify they are ignored
git status

# 4. Commit the .gitignore
git add .gitignore
git commit -m "Added .gitignore to ignore log files and folders"
```

## Exercise 3: Branching and Merging
```bash
# 1. Create a new branch and switch to it
git branch GitNewBranch
git checkout GitNewBranch
# (or git checkout -b GitNewBranch)

# 2. Add some files and commit
echo "New feature" > feature.txt
git add feature.txt
git commit -m "Added feature.txt in GitNewBranch"

# 3. Switch back to master
git checkout master

# 4. Check differences
git diff master..GitNewBranch

# 5. Merge the branch to trunk (master)
git merge GitNewBranch

# 6. Observe log and delete branch
git log --oneline --graph --decorate
git branch -d GitNewBranch
```

## Exercise 4: Merge Conflicts
```bash
# 1. Ensure master is clean
git status

# 2. Create a branch and add a file
git checkout -b GitWork
echo "Hello from GitWork" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in GitWork"

# 3. Switch back to master and create the same file with different content
git checkout master
echo "Hello from Master" > hello.xml
git add hello.xml
git commit -m "Added hello.xml in Master"

# 4. Merge the branch (will cause a conflict)
git merge GitWork

# 5. Resolve conflict manually or with a tool (e.g. edit hello.xml to keep both changes)
# <<< HEAD
# Hello from Master
# ===
# Hello from GitWork
# >>> GitWork
echo "Hello from Master and GitWork" > hello.xml

# 6. Commit the resolved file
git add hello.xml
git commit -m "Resolved merge conflict in hello.xml"

# 7. Delete the branch
git branch -d GitWork
```

## Exercise 5: Clean Up and Push
```bash
# 1. Verify master is clean
git status

# 2. Pull remote changes (if any)
# git pull origin master

# 3. Push all local changes to remote
# git push origin master
```
