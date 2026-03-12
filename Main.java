public class Main {
    // Задание 1.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    // Задание 2.
    public static void checkSumSign() {
        int a = 5;
        int b = 10;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
     // Задание 3.
     public static void printColor() {
            int value = 50;
            if (value <= 0) {
                System.out.println("Красный");
            }
            else if (value > 0 && value <= 100) {   //Заметка для себя: && - оператор "и", оба условия вокруг истинные одновременно
                System.out.println("Желтый");
            }
            else {
                System.out.println("Зеленый");
            }
        }

        // Задание 4.
        public static void compareNumbers() {
            int a = 10;
            int b = 5;
            if (a >= b) {
                System.out.println("a >= b");
        } else {
                System.out.println("a < b");
            }
        }

        // Задание 5.
        public static boolean checkSumLimit(int a, int b) {
            int sum = a + b;
            if (sum >= 10 && sum <= 20) { // Заметка: Проверка, что сумма больше или равна 10 и меньше или равна 20
                return true;
            } else {
                return false;
            }
        }

        // Задание 6.
        public static void printPositiveOrNegative(int value) {
            if (value >= 0) {
                System.out.println(value + " - положительное число");}
            else {
                System.out.println(value + " отрицательное число");
            }
            }

            // Задание 7.
            public static boolean isNegative(int value) {
                if (value < 0) {
                    return true;
                } else {
                    return false;
                }
                }

                // Задание 8
                public static void printStringTimes(String str, int times) {
                    for (int i = 0; i < times; i++) {
                        System.out.println(str);
                    }
                }

                // Задание 9
                public static boolean isLeapYear(int year) {
                    if (year % 400 == 0) { // Заметка:  % означает остаток от деления
                        return true;
                    } else if (year % 100 == 0) { // Заметка: == 0, остаток равен 0, значит число разделилось нацело (без остатка).
                        return false;
                    } else if (year % 4 == 0) { //Заметка: Проверка: Делится ли год на 4 без остатка?
                        return true;
                    } else {
                        return false;
                    }
                }

                // Задание 10
                public static void invertBinaryArray() {
                    int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0}; // создается коробка для чисел с названием arr, внутри 10 ячеек с числами.
                    System.out.print("Было: ");
                    for (int i = 0; i < arr.length; i++) { // arr.length — длина массива (количество ячеек). В данном случае их 10.
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();

                    for (int i = 0; i < arr.length; i++) { // Начинается цикл. int i = 0 — начинается с первой ячейки. после каждой проверки переход к следующей ячейке 0, потом 1, потом 2.
                        if (arr[i] == 1) { //  — смотрим в текущую ячейку. Если там единица?
                            arr[i] = 0; // стираем её и записываем ноль
                        } else { // если там ноль?
                            arr[i] = 1; // записываем единицу
                        }
                    }
                    System.out.print("Стало: ");
                    for (int i = 0; i < arr.length; i++) { // берем число из ячейки с номером i и печатаем его
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                }

                // Задание 11
                public static void fillArrayOneToHundred() {
                    int[] arr = new int[100]; // Создаём пустой массив длиной 100 с именем arr
                    for (int i = 0; i < arr.length; i++) { //Заполняем массив значениями от 1 до 100
                        arr[i] = i + 1; // цикл пробегает по всем ячейкам, прибавляет единицу
                    }
                    System.out.print("Первые 10 элементов: ");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();

                    System.out.print("Последние 10 элементов: ");
                    for (int i = 90; i < 100; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                }

                // Задание 12
                public static void multiplyLessThanSix() {
                    int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // создаём массив с заданными значениями
                    System.out.print("Было: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();

                    for (int i = 0; i < arr.length; i++) { // цикл пробегает по массиву и умножает на 2 числа меньше 6
                        if (arr[i] < 6) {
                            arr[i] = arr[i] * 2;
                        }
                    }
                    System.out.print("Стало: ");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                }

                // Задание 13
                public static void fillDiagonal() {
                    int size = 5; // Задаём размер массива
                    int[][] arr = new int[size][size]; // Создаём квадратный двумерный массив 5 на 5
                    for (int i = 0; i < size; i++) {
                        arr[i][i] = 1; // на диагонали координаты всегда одинаковые
                    }
                    for (int i = 0; i < size; i++) { //  Заполняем диагональ единицами
                        for (int j = 0; j < size; j++) { // Индексы диагональных элементов: [0][0], [1][1], [2][2]...
                            System.out.print(arr[i][j] + " "); // (i) — перебирает строки (0, 1, 2, 3, 4), (j) — перебирает столбцы в каждой строке
                        }
                        System.out.println();
                    }
                }

                // Задание 14
                public static int[] createFilledArray(int len, int initialValue) {
                    int[] arr = new int[len];
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = initialValue;
                    }
                    return arr;
                }

    public static void main(String[] args) { //запускаем все задания по очереди
        System.out.println("Задание 1");
        printThreeWords();

        System.out.println("Задание 2");
        checkSumSign();

        System.out.println("Задание 3");
        printColor();

        System.out.println("Задание 4");
        compareNumbers();

        System.out.println("Задание 5");
        System.out.println("5 + 6 в пределах 10-20? " + checkSumLimit(5, 6));
        System.out.println("1 + 2 в пределах 10-20? " + checkSumLimit(1, 2));

        System.out.println("Задание 6");
        printPositiveOrNegative(10);
        printPositiveOrNegative(-5);
        printPositiveOrNegative(0);

        System.out.println("Задание 7");
        System.out.println(isNegative(10));
        System.out.println(isNegative(-5));
        System.out.println(isNegative(0));

        System.out.println("Задание 8");
        printStringTimes("Hello", 3);

        System.out.println("Задание 9");
        System.out.println(isLeapYear(2026));
        System.out.println(isLeapYear(2015));
        System.out.println(isLeapYear(1997));
        System.out.println(isLeapYear(2000));

        System.out.println("Задание 10");
        invertBinaryArray();

        System.out.println("Задание 11");
        fillArrayOneToHundred();

        System.out.println("Задание 12");
        multiplyLessThanSix();

        System.out.println("Задание 13");
        fillDiagonal();

        System.out.println("Задание 14");
        int[] resultArray = createFilledArray(5, 42);
        for (int val : resultArray) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}