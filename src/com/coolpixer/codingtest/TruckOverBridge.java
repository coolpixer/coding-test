package com.coolpixer.codingtest;


import java.util.LinkedList;
import java.util.Queue;

import static com.coolpixer.codingtest.CommonUtil.msg;

/**
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 *
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 *
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 *  - bridge_length는 1 이상 10,000 이하입니다.
 *  - weight는 1 이상 10,000 이하입니다.
 *  - truck_weights의 길이는 1 이상 10,000 이하입니다.
 *  - 모든 트럭의 무게는 1 이상 weight 이하입니다.
 */
public class TruckOverBridge {
    public static void main(String[] args) {
        TruckOverBridge truckOverBridge = new TruckOverBridge();
        int result = truckOverBridge.solution(2, 10, new int[]{7, 4, 5, 6});
        msg(result);
    }

    static class Truck {
        private int weight = 0;
        private int howLongMoved = 0;

        public static Truck newInstance(int weight) {
            return new Truck().setWeight(weight);
        }

        public int getWeight() {
            return weight;
        }

        public Truck setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public int getHowLongMoved() {
            return howLongMoved;
        }

        public Truck setHowLongMoved(int howLongMoved) {
            this.howLongMoved = howLongMoved;
            return this;
        }

        public void move() {
            howLongMoved++;
        }

        public boolean crossed(int bridgeLength) {
            return (howLongMoved > bridgeLength);
        }

        public boolean isEdgeOnBridge(int bridgeLength) {
            return (howLongMoved == bridgeLength);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            // sb.append(weight)
            //         .append("-")
            //         .append(howLongMoved);
            sb.append(weight);
            return sb.toString();
        }
    }

    static class InnerSolution {
        private Queue<Truck> awaiting = new LinkedList<>();
        private Queue<Truck> onBridge = new LinkedList<>();
        private int weight = 0;
        private int answer = 0;
        private int bridgeLength = 0;

        private InnerSolution(int weight, int bridgeLength, int[] truckWeights) {
            this.weight = weight;
            this.bridgeLength = bridgeLength;
            for(int w : truckWeights) {
                awaiting.offer(Truck.newInstance(w));
            }
        }

        public static InnerSolution of(int bridgeLength
                , int weight
                , int[] truckWeights) {
            return new InnerSolution(weight, bridgeLength, truckWeights);
        }

        private boolean canMoveOnBridge(Truck next) {
            int total = 0;
            for (Truck t : onBridge) {
                if (t.isEdgeOnBridge(bridgeLength)) continue;
                total += t.getWeight();
            }
            return (total + next.getWeight() <= weight);
        }

        private void moveAllTrucksOnBridge() {
            for (Truck t : onBridge) {
                t.move();
            }
        }

        private void checkFinishedTruck() {
            Truck first = onBridge.peek();
            if (first.crossed(bridgeLength)) {
                onBridge.poll();
            }
        }

        public int solve() {
            while(!awaiting.isEmpty() || !onBridge.isEmpty()) {
                answer++;
                if(!awaiting.isEmpty()) {
                    Truck next = awaiting.peek();
                    if (canMoveOnBridge(next)) {
                        awaiting.poll();
                        onBridge.offer(next);
                    }
                }
                moveAllTrucksOnBridge();
                checkFinishedTruck();

                // msg("<{}> {}, {}", answer, onBridge, awaiting);
            }

            return answer;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = InnerSolution.of(bridge_length, weight, truck_weights)
                .solve();
        return answer;
    }
}
