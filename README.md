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
![KakaoTalk_20221208_181815280](https://user-images.githubusercontent.com/101496219/206895009-c5900170-9f95-4c16-a4a0-2bd3bbcf3faf.jpg)
https://www.erdcloud.com/d/HYzHyGEqKBBzjBZM4

## 기능 명세서
[기능 명세서보기](https://docs.google.com/spreadsheets/d/1dZZ9WDroy_Z0zwEdAzWC1t3ZqnuLQOsLEObZysph8Hc/edit?usp=sharing)

# 🤔개인적으로 프로젝트를 진행하면서 어려운 점
### ✔이규헌
1. 유효성 검사 코드 작성
spring boot 코드  
```java
        if (bindingResult.hasErrors()) {
            String referer = request.getHeader("Referer");
            redirectAttributes.addAttribute("referer",referer);
            return "redirect:"+ referer;
        } 
```
html 코드  
```html
<form action="/shop/payment.do" method="post" th:object="${orderDetail}">
                <div class="row product-info">
                    <div class="row py-5">
                        <div class="form-group col-md-3 mb-3">
                            <img class="card-img" th:src="@{/assets/img/productIMG/} + ${product.productPhoto}">
                        </div>
                        <div class="form-group col-md-6 mb-3">
                            <label for="name">상품명</label>
                            <input type="text" class="form-control mt-1"  th:field="${product.productName}" readonly>
                            <input type="hidden" class="form-control mt-1"  th:field="${product.productNum}" >

                            <label for="size">사이즈</label>
                            <input type="text" class="form-control mt-1"  th:field="${product.productSize}" readonly>

                            <label for="sex">성별</label>
                            <th:block th:switch="${product.sex}">
                                <input th:case="${'U'}" type="text" class="form-control mt-1"  th:field="${product.sex}" readonly>
                                <input th:case="${'M'}" type="text" class="form-control mt-1"  th:field="${product.sex}" readonly>
                                <input th:case="${'W'}" type="text" class="form-control mt-1"  th:field="${product.sex}" readonly>
                            </th:block>
                        </div>
                    </div>
                    <h3 style="color: red; text-align: center; margin-bottom: 30px" th:if="${param.get('referer') != null}" th:text="|입력정보를 다시한번 확인해주세요!|"></h3>
                   -- 중략--
```
**GET방식의 경우 한번 새로고침이 되면 GetMapping()으로 작성한 코드의 정보들이 날라가버린다는 점이 유효성 검사를 할때 어렵게 했습니다.**
저 위의 짧은 자바 코드를 생각해내는데 약 2일의 시간이 소요된거 같습니다.  
### 👍해결방법:  

request.getHeader("Referer");로 현재의 주소를 기억하고 있다가 Bindingresult에 Error가 담기면 이전 페이지로 리다이렉트하는 방법을 사용했습니다.

이와 동시에 **redirectAttributes.addAttribute("referer",referer);** 해당 주소도 같이 쿼리 스트링에 붙여서 보내줍니다.

이렇게 하면 새롭게 로딩된 페이지의 쿼리문에는 제가 원했던 쿼리문들을 전부 그대로 유지하면서 그와 동시에 모든 정보를 그대로 저장해둔채로 사용자에게 다시 보여줄 수 있게 되었습니다.  

Thymeleaf에서는 th:if="${param.get('referer') != null}"로 이 페이지가 새롭게 로딩된 페이지(오류가 있어서 새로고침이 되었는가?)인지를 판별할 수 있게 됩니다.

이와 같은 방법으로 경고문을 사용자에게 성공적으로 보여줄 수 있게 되었습니다.
-----------------------------------------

### ✔홍성배  

---------------------------------------

### ✔임정민  
-------------------------------------
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
