package DataStructures.stacks;

import java.util.LinkedList;
import java.util.List;

public class AsteroidColiison {
    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        new AsteroidColiison().asteroidCollision1(arr);
    }

    public int[] asteroidCollision1(int[] asteroids) {
        int i = 0;
        for (int ast : asteroids) {
            if (i > 0 && asteroids[i - 1] > 0 && ast < 0) {
                int temp = Math.abs(ast);
                if (asteroids[i - 1] < temp) {
                    while (i >= 0 && asteroids[i - 1] < temp) {
                        i = i - 1;
                    }
                    if (i >= 0 && asteroids[i - 1] == temp) {
                        i = i - 1;
                        continue;
                    }
                    asteroids[i] = -temp;
                    i++;
                } else if (asteroids[i - 1] > temp) {
                    i = i - 1;
                } else {
                    i = i - 1;
                }
            } else {
                asteroids[i] = ast;
                i++;
            }
        }
        int[] result = new int[i];
        for (int p = 0; p < i; p++) {
            result[p] = asteroids[p];
        }
        return asteroids;
    }


    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : asteroids) {
            if (list.isEmpty()) {
                list.addLast(i);
            } else {
                if (list.peekLast() > 0 && i < 0) {
                    if (list.getLast() < Math.abs(i)) {
                        while (!list.isEmpty() && list.getLast() < Math.abs(i)) {
                            list.pollLast();
                        }
                        if (!list.isEmpty() && list.getLast() > Math.abs(i)) {
                            continue;
                        }
                        list.add(i);
                    } else if (list.getLast() > Math.abs(i)) {
                        continue;
                    } else {
                        list.pollLast();
                    }
                }
//                else if (list.peekLast() < 0 && i > 0) {
//                    list.addLast(i);
//                }
                else {
                    list.addLast(i);
                }
            }
        }
        return new int[1];
    }
}