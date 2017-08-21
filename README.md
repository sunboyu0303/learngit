# learngit
https://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/

添加提交文件  git add readme.txt

提交本地资源库 git commit -m "wrote a readme file"

查看仓库当前的状态   git status

查看修改内容  git diff readme.txt
 
查看提交历史，以便确定要回退到哪个版本。  git log

回滚（指向的版本就是当前版本）  git reset --hard 3628164

查看命令历史，以便确定要回到未来的哪个版本。  git reflog

把readme.txt文件在工作区的修改全部撤销    git checkout -- readme.txt

这里有两种情况：

一种是readme.txt自修改后还没有被放到暂存区，现在，撤销修改就回到和版本库一模一样的状态；

一种是readme.txt已经添加到暂存区后，又作了修改，现在，撤销修改就回到添加到暂存区后的状态。

总之，就是让这个文件回到最近一次git commit或git add时的状态。

切换到dev分支    git checkout dev

把暂存区的修改撤销掉（unstage），重新放回工作区 git reset HEAD readme.txt

在文件管理器中把没用的文件删了 rm test.txt

从版本库中删除该文件  git rm test.txt

要关联一个远程库    git remote add origin git@server-name:path/repo-name.git

本地库的所有内容推送到远程库  git push origin master

创建dev分支，然后切换到dev分支  git checkout -b dev

相当于以下两条命令:
git branch dev
git checkout dev

命令查看当前分支    git branch

把dev分支的工作成果合并到master分支上：
git checkout master
git merge dev

删除dev分支 git branch -d dev

小结：

查看分支：git branch

创建分支：git branch <name>

切换分支：git checkout <name>

创建+切换分支：git checkout -b <name>

合并某分支到当前分支：git merge <name>

删除分支：git branch -d <name>

分支的合并情况 git log --graph --pretty=oneline --abbrev-commit

--no-ff参数，表示禁用Fast forward：git merge --no-ff -m "merge with no-ff" dev

当前工作现场“储藏”起来:   git stash

工作现场存到哪去了:  git stash list

但是需要恢复一下，有两个办法：

一是用git stash apply恢复，但是恢复后，stash内容并不删除，你需要用git stash drop来删除；

另一种方式是用git stash pop，恢复的同时把stash内容也删了：

可以多次stash，恢复的时候，先用git stash list查看，然后恢复指定的stash，用命令： git stash apply stash@{0}

如果要丢弃一个没有被合并过的分支，可以通过git branch -D <name>强行删除。

多人协作的工作模式通常是这样：

1.首先，可以试图用git push origin branch-name推送自己的修改；

2.如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；

3.如果合并有冲突，则解决冲突，并在本地提交；

4.没有冲突或者解决掉冲突后，再用git push origin branch-name推送就能成功！

如果git pull提示“no tracking information”，则说明本地分支和远程分支的链接关系没有创建，用命令git branch --set-upstream branch-name origin/branch-name。

小结

1.查看远程库信息，使用git remote -v；

2.本地新建的分支如果不推送到远程，对其他人就是不可见的；

3.从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；

4.在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；

5.建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；

6.从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。

打一个新标签: git tag v1.0

查看所有标签: git tag

查看标签信息: git show v0.9

小结

1.命令git tag <name>用于新建一个标签，默认为HEAD，也可以指定一个commit id；

2.git tag -a <tagname> -m "blablabla..."可以指定标签信息；

3.git tag -s <tagname> -m "blablabla..."可以用PGP签名标签；

4.命令git tag可以查看所有标签。

标签打错了，也可以删除:    git tag -d v0.1

要推送某个标签到远程，使用命令:    git push origin <tagname>：

一次性推送全部尚未推送到远程的本地标签:    git push origin --tags

从远程删除。删除命令也是push，但是格式如下： git push origin :refs/tags/v0.9

小结

1.命令git push origin <tagname>可以推送一个本地标签；

2.命令git push origin --tags可以推送全部未推送过的本地标签；

3.命令git tag -d <tagname>可以删除一个本地标签；

4.命令git push origin :refs/tags/<tagname>可以删除一个远程标签。
