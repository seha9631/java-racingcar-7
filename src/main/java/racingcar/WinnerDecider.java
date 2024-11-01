package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WinnerDecider {
    private ArrayList<Car> cars;

    public WinnerDecider(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void decideWinner() {
        List<String> winners = selectWinner(findMaxForwardCount());
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.getFirst());
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    private int findMaxForwardCount() {
        int maxForwardCount = 0;
        for (Car car : cars) {
            if (car.getForwardCount() > maxForwardCount) {
                maxForwardCount = car.getForwardCount();
            }
        }
        return maxForwardCount;
    }

    private List<String> selectWinner(int maxForwardCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
