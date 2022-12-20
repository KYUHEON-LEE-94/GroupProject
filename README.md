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

## 주요 기능
### 회원가입
![signup](https://user-images.githubusercontent.com/101496219/208396437-b0fb2101-01a0-4884-b6c5-1cbd9202f9d2.png)  
**회원가입 페이지입니다.**  
### 종류별 제품 보기 +(페이징 처리)
![shop](https://user-images.githubusercontent.com/101496219/208609797-ff4dbb21-0f1e-43d7-817d-9157225aeac0.png)
**성별과 상품별로 볼수 있는 카테고리별 분류와 페이징 처리가 되어있는 화면입니다. + 별점도 확인가능합니다.**  
### 주문하기
![주문](https://user-images.githubusercontent.com/101496219/208280836-9dfef564-fcc7-4ce5-8779-9adfd7cfe76c.png)  
**필요 정보를 입력받아 주문할 수 있는 화면입니다.**  
### 장바구니
![cart](https://user-images.githubusercontent.com/101496219/208386830-a7798fa7-ffa1-4a04-990c-dfba9e93ebad.png)
**사용자가 담아둔 목록을 볼 수 있습니다.**
### 문의하기
![contact](https://user-images.githubusercontent.com/101496219/208280863-09e77b78-1502-45be-b2cf-09d8802df75f.png)  
**간단한 정보를 받아서 문의할 수 있는 화면입니다.**  
### 유효성 검증
![valid1](https://user-images.githubusercontent.com/101496219/208280866-60a25d31-ce75-4e83-8b47-315b140e224c.png)  
**문의화면의 유효성 검증**  
![valide2](https://user-images.githubusercontent.com/101496219/208280871-d5c0dd69-031b-4b72-baf2-dd1316e83154.png)  
**주문 화면의 유효성 검증**  
![valide3](https://user-images.githubusercontent.com/101496219/208396641-fc807889-6e29-42d8-ba72-0749b3895795.png)
**회원가입 화면의 유효성 검증**  



# 🤔개인적으로 프로젝트를 진행하면서 어려운 점
### ✔이규헌
1. 유효성 검사 코드 작성
spring boot 코드  
```java
//          각 FieldError들을 받아서 쿼리 스트링으로 기억해서, 부분적으로 발생하는 부분에 대해서만 경고안내를 보여줄 수 있음
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
            //한군데라도 에러가 발생하면 띄울 전체 경고문구
                redirectAttributes.addAttribute("someError","someError");
                //각 부분의 경고문구
                redirectAttributes.addAttribute(error.getField().toString(),error.getField().toString());
            }

            //이전 페이지 주소 기억해서 해당 페이지로 redirect하고 쿼리 스트링으로 기억
            String referer = request.getHeader("Referer");

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

이와 동시에 **redirectAttributes.addAttribute(error.getField().toString(),error.getField().toString());** 발생하는 FieldError와 그내용을 쿼리 스트링으로 함께 보내줍니다.

이렇게 하면 새롭게 로딩된 페이지의 쿼리문에는 제가 원했던 쿼리문들을 전부 그대로 유지하면서 그와 동시에 모든 정보를 그대로 저장해둔채로 사용자에게 다시 보여줄 수 있게 되었습니다.  

Thymeleaf에서는 th:if="${param.get('recipientName') != null}로 이 페이지가 새롭게 로딩된 페이지(오류가 있어서 새로고침이 되었는가?)인지를 판별할 수 있게 됩니다.

![image](https://user-images.githubusercontent.com/101496219/208081798-1ba16706-7e46-48eb-b213-82d2ef4143d1.png)


이와 같은 방법으로 경고문을 사용자에게 성공적으로 보여줄 수 있게 되었습니다.

2. 카테고리별 상품 분류
```html
     <li class="pb-3" th:href="@{/shop(searchAll=8000)}">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none"  th:text="#{web.shop.MantoMan }">
                            MantoMan
                            <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                        </a>
                        <ul id="collapseTwo" class="collapse list-unstyled pl-3">
                            <li><a class="text-decoration-none" th:href="@{/shop(searchAll=8000)}">All</a></li>
                            <li><a class="text-decoration-none" th:href="@{/shop(search=8000)}" th:text="#{web.shop.MantoMan.Club}">Club</a></li>
                            <li><a class="text-decoration-none" th:href="@{/shop(search=8001)}" th:text="#{web.shop.MantoMan.OverFit}">OverFit</a></li>
                        </ul>
                    </li>
                    <li class="pb-3">
                        <a class="collapsed d-flex justify-content-between h3 text-decoration-none" th:text="#{web.shop.Hood}">
                            Hood
                            <i class="pull-right fa fa-fw fa-chevron-circle-down mt-1"></i>
                        </a>
                        <ul id="collapseThree" class="collapse list-unstyled pl-3">
                            <li><a class="text-decoration-none" th:href="@{/shop(searchAll=8501)}">All</a></li>
                            <li><a class="text-decoration-none" th:href="@{/shop(search=8501)}" th:text="#{web.shop.Hood.Heavy}">Heavy</a></li>

                        </ul>
                    </li>
                    중략
```

```java
public String ProductPaging(@PageableDefault(page = 0, size = 6, sort = "productQuantity", direction = Sort.Direction.DESC) Pageable pageable,
								@RequestParam(required = false, defaultValue = "") String search,
								@RequestParam(required = false, defaultValue = "") Integer searchAll,
								Model model) {
		//th:object 설정을 위한 Model.
		Product product = new Product();
		model.addAttribute("product", product);

		//paging 처리를 위한 service 처리
		Page<Product> page = service.findProducts(search, pageable);

		//만약 searchALl(모두 검색) 파라미터가 있다면 아래와 같이 처리를 하겠다.
		/**
		 * 8000 = 모든 맨투맨
		 * 8501 = 모든 후드티
		 */
		if(searchAll != null){
			if (8000 == searchAll){
				Integer searAllTo = 8500;
				page = service.findAllByTypeNumBetween(searchAll,searAllTo, pageable);
			}else if(8501 == searchAll ){
				Integer searAllTo = 9000;
				page = service.findAllByTypeNumBetween(searchAll,searAllTo, pageable);
			}

		}
```
**Shop 페이지를 만들때 제일 많은 고민을 한 부분입니다. ++

### 👍해결방법:  
카테고리별 상품분류 번호를 쿼리스트링으로 같이 넘겨서 처리하는 방법을 사용했습니다.  
각 상품은 분류번호를 가지고 있게 ERD로 설계되어있습니다.  
하여, 해당 번호를 쿼리 스트링으로 넘기고, Controller에서는 해당 번호를 받아서 상품별 목록을 처리할 수 있도록 코딩했습니다.
각 상품을 누를경우에는 search를 key값으로 하였고, All 버튼을 누를경우에는 SearchAll을 key값으로 사용하였습니다.
그리고 특정 상품번호의 시작 분류번호값 ~ 끝 분류번호 값을 입력받을 수 있도록 설정하여 이 문제를 해결하였습니다.

3. REST API 개념 적용
``` java
    @PostMapping("/{memberId}")
    //장바구니 아이콘을 눌렀을때 장바구니 목록에 담고, redirect
    public String PostCart(@PathVariable(required = false) String memberId,
                           @RequestParam(value = "product-quanity", required = false, defaultValue = "1") Integer productQuantity,
                           @RequestParam("productNum") String productNum,
                           HttpServletRequest request){
        //장바구니 DB에 저장하는 코드
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setShoppingQuantity(productQuantity);
        shoppingBasket.setProductNum(productNum);

        if(memberId != null){
            shoppingBasket.setMemberId(memberId);
        }
        shoppingBasketService.register(shoppingBasket);
        return  "redirect:/shop/cart/{memberId}";
    }
```

```java
    @GetMapping("/{memberId}")
    public String showCart(@ModelAttribute("orderDetail") OrderDetail orderDetail,
                           @PathVariable(required = false) String memberId,
                           HttpServletRequest request,
                           Model model){

        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");
        if(members.getMemberId() == null){
            throw new YzRuntimeException();
        }


        List<ShoppingBasket> list = shoppingBasketService.findAllByMemberIdOrderByShoppingDateDesc(members.getMemberId());
        model.addAttribute("list", list);

            List<Product> products = new ArrayList<>();
            for (ShoppingBasket cart: list) {
                Product product = productService.findByProductNum(cart.getProductNum());
                products.add(product);
            }
        model.addAttribute("products",products);
        return "includes/cart";
    }
```

shop.html  
```html
                     <form th:if="${members != null}" th:action="@{/shop/cart/}+${members.getMemberId()}" method="post">
                                            <input type="hidden" name="productNum" th:value="${listpro.productNum}">
                                            <input type="hidden" name="roduct-quanity" th:value="${listpro.productQuantity}">
                                            <li><button type="submit" class="btn btn-success text-white mt-2"><i class="fas fa-cart-plus"></i></button></li>
                                        </form>

                                        <form th:if="${members == null}">
                                        </form>
```

**처음으로 REST API 개념 적용을 시도한 부분입니다. ++

### 👍해결방법:  
샵 페이지에서 로그인되어 있는 사용자에게만 카트 아이콘이 보이도록 설정했습니다.
![cartIcon](https://user-images.githubusercontent.com/101496219/208403176-1136009a-a9dc-4b40-bbab-c050a15e0181.png)
해당 아이콘을 누르면, 장바구니 DB에 저장되는 동시에 사용자 ID에 해당하는 장바구니 페이지로 리다이렉트될 수있도록 설정하였습니다.
처음으로 **@PathVariable**을 사용하였기 때문에 Get, Post 로직에 대하여 혼동이 있어서 약간의 시행착오를 겪어야 했습니다.
**여러번 시도하고 공부한 끝에 성공적으로 REST API 개념을 적용하여 장바구니 페이지를 보여줄 수 있도록 하였습니다. **
-----------------------------------------


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
