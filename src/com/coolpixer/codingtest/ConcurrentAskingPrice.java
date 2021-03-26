package com.coolpixer.codingtest;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 매도, 매수 주문간의 동시호가 체결가격과 체결가능수량을 구한다.
 * 가격별 주문 가능 수량을 산정하여 최대 다수의 주문이 가능한 가격을 체결가로 정한다.
 *
 * 다음 함수를 작성 :
 *  class ConcurrentAskingPrice { int[] solution(Object[][] S, Object[][] B) }
 *
 * S : 매도 주문 내역(주문자 이름, 수량, 가격)
 * B : 매수 주문 내역(주문자 이름, 수량, 가격)
 *
 * 예를 들면 다음과 같다.
 *  S : [ ["a", 500, 19500], ["b", 500, 20000] ]
 *  B : [ ["A", 500, 20500], ["B", 700, 20000] ]
 *
 *  함수는 다음을 반환해야 한다. [20000, 1000]
 */
public class ConcurrentAskingPrice extends BaseSolution {
    public static void main(String[] args) {
        Object[][] sell = {
                { "a", 500, 19500 }
                , { "b", 500, 20000 }, { "c", 1000, 20000 }
                , { "d", 2000, 20500 }
                , { "e", 1700, 21000 }
        };

        Object[][] buy = {
                { "A", 500, 20500 }
                , { "B", 700, 21000 }, { "C", 500, 20000 }
                , { "F", 2000, 19500 }, { "E", 1000, 19500 }
                , { "F", 1000, 19000 }
        };

        int[] result = (new ConcurrentAskingPrice()).solution(sell, buy);
        msg("fill price : {}", DecimalFormat.getInstance().format(result[0]));
        msg("fill amount : " + result[1]);
    }

    public int[] solution(Object[][] S, Object[][] B) {
        List<Order> sellOrders = Arrays.stream(Optional.ofNullable(S).orElseGet(()
                -> new Object[][]{}))
                .map(e -> Order.of((String) e[0], (int) e[2], (int) e[1]))
                .collect(Collectors.toList());

        List<Order> buyOrders = Arrays.stream(Optional.ofNullable(B).orElseGet(()
                -> new Object[][]{}))
                .map(e -> Order.of((String) e[0], (int) e[2], (int) e[1]))
                .collect(Collectors.toList());

        /* 매도, 매수 주문간의 금액 대역 구하기 */

        // price stream 만을 합친 뒤 distinct 처리할 수도 있음
        // 성능은 아래 코드가 더 나아보인다.
        // List<Integer> priceBandwidth = Stream.concat(sellOrders.stream().map(Order::getPrice)
        //         , buyOrders.stream().map(Order::getPrice))
        //         .distinct()
        //         .collect(Collectors.toList());

        Set<Integer> priceBandwidth = new HashSet<>();
        sellOrders.stream().forEach(e -> priceBandwidth.add(e.getPrice()));
        buyOrders.stream().forEach(e -> priceBandwidth.add(e.getPrice()));

        Integer fillPrice = 0, fillAmount = 0;

        for(Integer p : priceBandwidth) {
            Integer availSellOrderAmount = sellOrders.stream()
                    .filter(o -> o.price <= p)
                    .mapToInt(Order::getAmount).sum();
            Integer availBuyOrderAmount = buyOrders.stream()
                    .filter(o -> o.price >= p)
                    .mapToInt(Order::getAmount).sum();

            // msg(p + ":" + availSellOrderAmount + ":" + availBuyOrderAmount);
            Integer amount = Math.min(availSellOrderAmount, availBuyOrderAmount);
            if(fillAmount < amount) {
                fillPrice = p;
                fillAmount = amount;
            }
        }

        return new int[] { fillPrice, fillAmount };
    }

    static class Order {
        private String name;
        private int price;
        private int amount;
        private int fillAmount = 0;

        public static Order of(String name, int price, int amount) {
            return new Order(name, price, amount);
        }

        public Order(String name, int price, int amount) {
            this.name = name;
            this.price = price;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getFillAmount() {
            return fillAmount;
        }

        public void setFillAmount(int fillAmount) {
            this.fillAmount = fillAmount;
        }

        @Override
        public String toString() {
            return String.format("%s : %d - %d : %d", name, price, amount, fillAmount);
        }
    }
}
