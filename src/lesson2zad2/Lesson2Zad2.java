/*
1. Создайте зубчатый массив, в котором хранится
температура воздуха в нашем городе на весь год.
Массив должен содержать 12 строк, количество
столбцов - количество дней в месяце.
2.Заполните массив случайными числами. Температура
зависит от времени года.
3.Программа должна вывести на экран
-погоду на указанную дату (месяц, день – пользователь
вводит данные с помощью клавиатуры)
-в какие дни была самая теплая и самая холодная погода
-среднюю температуру по каждому месяцу
 */
package lesson2zad2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson2Zad2 {
    enum nameMonth {января, февраля, марта, апреля, мая, июня, июля, августа, сентября, октября, ноября, декабря};
    public static void main(String[] args) {
        int[] koldn = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[][] tempArray = new int[12][];
        int klmonth, klday, sumTemp, minTemp, maxTemp;
        maxTemp = -100;
        minTemp = 100;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Введите месяц: ");
        klmonth = scanner.nextInt();
        System.out.print("Введите день: ");
        klday = scanner.nextInt();
        
        if(klmonth > 12 || klmonth < 1) {
            System.out.println("Ошибка в номере месяца");
        }else{
            if(klday < 1 || klday > koldn[klmonth-1]){
                System.out.println("Неправильно введен день месяца");
            }else{
                for(int i=0; i < 12; i++){
                    tempArray[i] = new int[koldn[i]];
                    for(int j=0; j < koldn[i]; j++){
                        tempArray[i][j] = i;
                        switch (i+1){
                            case 12: case 1: case 2:
                                tempArray[i][j] = random.nextInt(10) - 20;
                                break;
                            case 3: case 4: case 5:
                                tempArray[i][j] = random.nextInt(5) + 5;
                                break;
                            case 6: case 7: case 8:
                                tempArray[i][j] = random.nextInt(15)+ 15;
                                break;
                            case 9: case 10: case 11:
                                tempArray[i][j] = random.nextInt(10);
                                break;
                        }
                        if(minTemp >= tempArray[i][j]) minTemp = tempArray[i][j];
                        if(maxTemp <= tempArray[i][j]) maxTemp = tempArray[i][j];
                    }
                    System.out.println(Arrays.toString(tempArray[i]));
                }
                System.out.println("----------------------------------------------------------");
                System.out.printf("На дату %2d %s : температура воздуха %3d градус(ов/а)%n",klday,nameMonth.values()[klmonth-1], tempArray[klmonth-1][klday-1]);
                System.out.println("----------------------------------------------------------");
                System.out.println("Средние температуры по месяцам:");
                for(int i=0; i < 12; i++){
                    sumTemp = 0;
                    for(int j=0; j < koldn[i]; j++){
                        sumTemp += tempArray[i][j];
                    }
                    System.out.printf("%2d | %6.2f",i+1,(float)sumTemp/koldn[i]);
                    System.out.println("");
                }
                System.out.println("---------------------------------------");
                System.out.println("Самая холодная погода "+ minTemp + " градус(ов/а):");
                for(int i=0; i < 12; i++){
                    for(int j=0; j < koldn[i]; j++){
                        if( minTemp == tempArray[i][j] ) System.out.printf(" %02d.%02d ",j+1,i+1);
                    }
                }
                System.out.println("");
                System.out.println("---------------------------------------");
                System.out.println("Самая теплая погода "+ maxTemp + " градус(ов/а):");
                for(int i=0; i < 12; i++){
                    for(int j=0; j < koldn[i]; j++){
                        if( maxTemp == tempArray[i][j] ) System.out.printf(" %02d.%02d ",j+1,i+1);
                    }
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
