package com.company.dymrin4_1;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
    }

    /*
    Задан массив случайных чисел.
    Написать метод который вернет массив в котором сначала будут все четные элементы, а потом все нечетные из исходного.
    */
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    /*
    Вам дана сетка row x col, представляющая карту, где grid [i] [j] = 1 представляет землю, а grid [i] [j] = 0 представляет воду.
    Ячейки сетки соединены горизонтально / по вертикали (не по диагонали).
    Сеть полностью окружена водой, и есть ровно один остров
    (то есть одна или несколько связанных сухопутных ячеек).
    На острове нет "озер", то есть воды внутри нет.
    Не соеденен с водой вокруг острова.
    Одна ячейка представляет собой квадрат со стороной 1.
    Сетка прямоугольная, ширина и высота не превышают 100. Определите периметр острова.
     */

    public int islandPerimeter(int[][] grid) {
        int amount = 0;
        if (grid.length == 1) {
            for (int i = 0; i < grid[0].length; i++) {
                amount += grid[0][i];
            }
            return amount * 2 + 2;
        }
        if (grid[0].length == 1) {
            for (int i = 0; i < grid.length; i++) {
                amount += grid[i][0];
            }
            return amount * 2 + 2;
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    amount += 4 - (grid[i - 1][j] + grid[i + 1][j] +
                            grid[i][j - 1] + grid[i][j + 1]);
                }
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            if (grid[i][0] == 1) {
                amount += 4 - (grid[i - 1][0] + grid[i + 1][0] + grid[i][1]);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                amount += 4 - (grid[i - 1][grid[0].length - 1] +
                        grid[i + 1][grid[0].length - 1] +
                        grid[i][grid[0].length - 2]);
            }
        }
        for (int j = 1; j < grid[0].length - 1; j++) {
            if (grid[0][j] == 1) {
                amount += 4 - (grid[0][j - 1] + grid[0][j + 1] + grid[1][j]);
            }
            if (grid[grid.length - 1][j] == 1) {
                amount += 4 - (grid[grid.length - 1][j - 1] +
                        grid[grid.length - 1][j + 1] +
                        grid[grid.length - 2][j]);
            }
        }

        amount += grid[0][0] == 0 ? 0 : 4 - (grid[0][1] + grid[1][0]);
        amount += grid[grid.length - 1][0] == 0 ? 0 : 4 - (grid[grid.length - 2][0] + grid[grid.length - 1][1]);
        amount += grid[0][grid[0].length - 1] == 0 ? 0 : 4 - (grid[0][grid[0].length - 2] + grid[1][grid[0].length - 1]);
        amount += grid[grid.length - 1][grid[0].length - 1] == 0 ? 0 : 4 - (grid[grid.length - 1][grid[0].length - 2] + grid[grid.length - 2][grid[0].length - 1]);
        return amount;
    }

    /*
    Дан массив строк emails где мы отправляем письмо на каждый email[i],
    вернуть число различных адресов которые получили письма.
    */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String theString : emails) {
            String[] parts = theString.split("@");
            parts[0] = parts[0].replaceAll("\\.", "");
            set.add(parts[0].split("\\+")[0] + "@" + parts[1]);
        }
        return set.size();
    }
}
