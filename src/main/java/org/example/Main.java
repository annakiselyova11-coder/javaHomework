package org.example;

public class Main {
    public static int calculateSum(String[][] array)

    throws MyArraySizeException, MyArrayDataException  {
        if (array.length !=4) {
            throw new MyArraySizeException("Неверное количество строк: " + array.length + ". Ожидается 4.");
        }
        for (int i = 0; i < array.length; i ++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Неверное количество столбцов в строке " + i);
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        String[][] array = {
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","13","15","16"}
        };

        try {
            int result = calculateSum(array);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] numbers = {1,2,3};
            int value = numbers[5];
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println("Исключение: " + e.getMessage());
        }

        }

    }

