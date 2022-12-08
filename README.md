# GroupProject
설명: 맨투맨과 후드티와 같은 미니멀 스타일의 쇼핑몰입니다.
카테고리에 따른 자유롭고 편안한 웹 쇼핑이 가능하도록 하는 것이 저희의 목표입니다.

## 프로젝트 팀
✔ 이규헌(panpan68@naver.com) [팀장]  
✔ 홍성배(qnazl0925@naver.com) [팀원]  
✔ 임지연(skechc@naver.com) [팀원] 

## 프로젝트 목표
+ 맨투맨, 후드티를 전문적으로 파는 쇼핑몰 웹사이트
+ Spring boot를 베이스로 웹 사이트 구현

## 사용스킬
프론트엔드: 부트스트랩  
백엔드: Spring boot, JPA, Mybatis, Thymleaf, lombok

## 스토리보드
https://ovenapp.io/view/R9YpEp61aE2kV6khxtQVu1BsoZC5Z8Fl/

## 데이터 모델링
https://www.erdcloud.com/d/HYzHyGEqKBBzjBZM4

## 기능 명세서
[기능 명세서보기](https://docs.google.com/spreadsheets/d/1dZZ9WDroy_Z0zwEdAzWC1t3ZqnuLQOsLEObZysph8Hc/edit?usp=sharing)

# commit 템플릿 설정하는 방법
### 이미 템플릿 파일은 폴더에 추가되어 있어서 아래의 절차대로만 하시면 됩니다.

1.템플릿 설정하기
git config --global commit.template .gitmessage.txt

2.커밋 메시지 작성하기
2-1. git add [파일명]로 스테이지에 갱신할 파일을 추가하고

3.아래의 명령어로 커밋하세요
git commit
![이미지](https://user-images.githubusercontent.com/101496219/206132909-44df1208-ea95-4376-a4e5-4c3b0f97996b.png)
> 위의 이미지대로 템플릿이 화면에 표시되었다면 아래의 코드를 참조해서 내용을 수정하면 됩니다.

**i: insert키로 수정기능
** q: 수정한내용 저장X, 탈출
** :wq : 수정한내용 저장하고 탈출 

4. :wq를 한후에 git -log를 확인하면 commit되어있는 것을 확인가능합니다.

5. 완료됬다면 push
