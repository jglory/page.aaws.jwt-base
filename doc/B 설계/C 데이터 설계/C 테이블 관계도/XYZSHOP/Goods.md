
| 문서 코드  | XYZ-BCC-000001                                                                                                                    |
| ------ | --------------------------------------------------------------------------------------------------------------------------------- |
| 데이터베이스 | xyz-db                                                                                                                            |
| 관련 문서  | [[../../../../A 분석/A 업무 분석/C 바운디드 컨텍스트 맵/바운디드 컨텍스트 맵\|XYZ-AAC-000001]]<br>[[../../B 테이블 정의서/XYZSHOP/Goods\|XYZ-BCB-000001 Goods]] |
| 설명     | XYZ 쇼핑몰 상품 영역 테이블 관계도                                                                                                             |
| 태그     | #설계 #테이블_관계도                                                                                                                      |
<br>

[[canvas/XYZ-BCC-000001.canvas|캔버스 뷰]]

<br>

```plantuml

' hide the spot
hide circle

skinparam defaultFontName "Noto Sans CJK KR"

' avoid problems with angled crows feet
skinparam linetype ortho


entity EventGoods <<이벤트 상품 정보>> {
  --
  * event_goods_id '이벤트 상품 아이디'
  * funnel '유입 경로'
}

entity DeliveryPolicy <<배송 정책 정보>> {
  --
  * delivery_policy_id '배송 정책 정보 아이디'
}

entity Member <<회원 기본 정보>> #lightblue {
  --
  * member_id '회원 정보 아이디'
}

entity Cart <<회원 카트 정보>> #lightblue {
   --
   goods_id '상품 정보 아이디'
   member_id '회원 정보 아이디'
}

entity Order <<주문 기본 정보>> #lightblue {
  --
   * order_id '주문 기본 정보 아이디'
}

entity OrderDetail <<주문 세부 정보>> {
  --
    * order_id '주문 기본 정보 아이디'
    * order_detail_id '주문 세부 정보 아이디'
}

entity OrderDetailStateHistory <<주문 세부 정보 상태 변화 기록>> {
  --
  * order_id '주문 기본 정보 아이디'
  * order_detail_id '주문 세부 정보 아이디'
  * create_dt '기록 일시'
  * order_detail_state_code '주문 세부 내역 상태 코드'
}

entity Payment <<결제 기본 정보>> #lightblue {
  --
  member_id '회원 정보 아이디'
  card_goods_id '카드 상품 정보 아이디'
}

entity Goods <<상품 정보>> #lightblue {
  --
  * goods_id '상품 정보 아이디'
  --
  delivery_policy_id '배송 정책 정보 아이디'
}

entity GoodsOrderPath <<상품 주문 접수 경로 정보>> {
  --
  * goods_id '상품 정보 아이디'
}

entity GoodsPaymentMethod <<상품 결제 수단 정보>> {
  --
  * goods_id '상품 정보 아이디'
  * payment_method_id '결제 수단 정보 아이디'
}

entity WishList <<위시 리스트>> {
   --
  member_id '회원 정보 아이디'
  goods_id '상품 정보 아이디'
}

entity TempOrder <<임시 주문 정보>> {
   --
  member_id '회원 정보 아이디'
  order_id '주문 정보 아이디'
}

entity TempOrderPayment <<임시 주문 결제 정보>> {
   --
  card_goods_id '카드 상품 정보 아이디'
}


Member ||--o{ Cart : Member.member_id - Cart.member_id
Member ||--o{ Payment : Member.member_id - Payment.member_id
Member ||---o{ WishList : Member.member_id - WishList.member_id
Member ||----o{ TempOrder: Member.member_id - TempOrder.member_id

Order ||--{ OrderDetail : Order.order_id - OrderDetail.order_id

OrderDetail ||--|| DeliveryPolicy : OrderDetail.delivery_policy_id - DeliveryPolicy.delivery_policy_id
OrderDetail ||--{ OrderDetailStateHistory: OrderDetail.(order_id,order_detail_id) - OrderDetailStateHistory.(order_id,order_detail_id)

Goods ||--o{ EventGoods: Goods.goods_id - EventGoods.event_goods_id
Goods ||---o{ Cart: Goods.goods_id - Cart.goods_id
Goods ||---o{ Payment : Goods.goods_id - Payment.card_goods_id
Goods ||----|| DeliveryPolicy : Goods.delivery_policy_id - DeliveryPolicy.delivery_policy_id
Goods ||-----o| GoodsOrderPath : Goods.goods_id - GoodsOrderPath.goods_id
Goods ||-----o| GoodsPaymentMethod : Goods.goods_id - GoodsPaymentMethod.goods_id
Goods ||-----o| WishList : Goods.goods_id - WishList.goods_id
Goods ||------o| TempOrderPayment : Goods.goods_id - TempOrderPayment.card_goods_id


```
