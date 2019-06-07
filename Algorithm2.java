

import java.util.ArrayList;

public class Algorithm2 {

    public static void main(String[] args) {

        Algorithm2 playground = new Algorithm2();

        System.out.println(playground.dataFormatter(new int[]{1, 3, 4, 5, 7, 8}));
        System.out.println(playground.dataFormatter(new int[]{1, 2, 3, 6, 9, 12, 13}));
        System.out.println(playground.dataFormatter(new int[]{1, 2, 3, 5, 7, 9}));

    }


    public String dataFormatter(int[] numbers) {

        String result = "";
        ArrayList<Integer> waitingList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (waitingList.isEmpty() || numbers[i] == waitingList.get(waitingList.size() - 1) + 1) {
                waitingList.add(numbers[i]);
            } else {

                if (waitingList.size() > 1) {
                    result += waitingList.get(0) + "-" + waitingList.get(waitingList.size() - 1) + ", ";
                } else {
                    result += waitingList.get(0) + ", ";
                }
                waitingList.clear();
                waitingList.add(numbers[i]);
            }

            if (i == numbers.length - 1) {
                if (waitingList.size() > 1) {
                    result += waitingList.get(0) + "-" + numbers[i];
                } else {
                    result += numbers[i];
                }
            }
        }


        return result;
    }
}
