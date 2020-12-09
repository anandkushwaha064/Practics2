set url=https://github.com/anandkushwaha064/Practics2.git

git init
git config --global user.name "anandkushwaha064"
git config --global user.email "anandkushwaha064@gmail.com"
git status
git add .
git commit -m "firstcommit"
git remote add origin %url%
git push -u origin master
start chrome %url%