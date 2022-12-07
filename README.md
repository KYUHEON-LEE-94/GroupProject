# GroupProject

# commit 템플릿 설정하는 방법
### 이미 템플릿 파일은 폴더에 추가되어 있어서 아래의 절차대로만 하시면 됩니다.

1.템플릿 설정하기
git config --global commit.template .gitmessage.txt

2.커밋 메시지 작성하기
2-1. git add [파일명]로 스테이지에 갱신할 파일을 추가하고

3.아래의 명령어로 커밋하세요
git commit
![이미지](https://user-images.githubusercontent.com/101496219/206132909-44df1208-ea95-4376-a4e5-4c3b0f97996b.png)

**i: insert키로 수정기능
** q: 수정한내용 저장X, 탈출
** :wq : 수정한내용 저장하고 탈출 

4. :wq를 한후에 git -log를 확인하면 commit되어있는 것을 확인가능합니다.

5. 완료됬다면 push
