package com.javarush.task.task22.task2213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by XPMUser on 4/17/19.
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrixA;
        matrixA = new int[4][3];

        matrixA[0][0] = 1;
        matrixA[0][1] = 1;
        matrixA[0][2] = 1;
        matrixA[1][0] = 1;
        matrixA[1][1] = 0;
        matrixA[1][2] = 1;
        matrixA[2][0] = 0;
        matrixA[2][1] = 0;
        matrixA[2][2] = 0;
        matrixA[3][0] = 0;
        matrixA[3][1] = 1;
        matrixA[3][2] = 0;
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j]);
            }
            System.out.println();
        }
        int sizeLine = 0;
        int iLength = matrixA.length;
        System.out.println(iLength);
        List<int[]> listOfLists = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < matrixA.length; i++) {
            sizeLine = matrixA[i].length;
            for (int j = 0; j < matrixA[i].length; j++) {
              sum += matrixA[i][j];
            }
            //System.out.print(sum);
            if(sum == matrixA[i].length) {
                matrixA[i] = null;
                System.out.print("***");
            }
            else if (sum>0 && sum<matrixA[i].length){
                listOfLists.add(matrixA[i]);
            }
            System.out.println();
            sum=0;

        }
        int[] data = IntStream.generate(() -> 0).limit(sizeLine).toArray();

        while (listOfLists.size()!=iLength)
            listOfLists.add(0,data);

        for (int[] i: listOfLists){
            System.out.println(Arrays.toString(i));
            System.out.println("-----------");
        }

        for (int i = 0; i < matrixA.length; i++) {
            matrixA[i] = new int[listOfLists.get(i).length];
        }
        for(int i=0; i<listOfLists.size(); i++){
            for (int j = 0; j < listOfLists.get(i).length; j++) {
                matrixA[i][j] = listOfLists.get(i)[j];
            }
        }




        //Например так:
        //Создаем список для хранения линий
        //Копируем все непустые линии в список.
        //Добавляем недостающие строки в начало списка.
        //Преобразуем список обратно в матрицу
      /*  int iLength = matrixA.length;
        int jLength = matrixA[0].length;
        List<List<Integer>> listOfLists = new ArrayList<>(iLength);
        for (int i = 0; i < iLength; i++) {
            listOfLists.add(new ArrayList(jLength));
            for (int j = 0; j < jLength; j++) {
                listOfLists.get(i).add(matrixA[i][j]);
            }
        }
        for (int i = 0; i < listOfLists.size(); ++i) {
           if ((!listOfLists.get(i).contains(0)&&listOfLists.get(i).contains(1))||(listOfLists.get(i).contains(0)&&!listOfLists.get(i).contains(1))){
               listOfLists.remove(listOfLists.get(i));
           }
        }
        List newlist = new ArrayList<Integer>();
        for (int i = 0; i < jLength; i++) {
            newlist.add(0);
        }

            while (listOfLists.size()!=iLength)
            listOfLists.add(0,newlist);

        System.out.println(listOfLists);

       matrixA = new int[listOfLists.size()][];
        for (int i = 0; i < matrixA.length; i++) {
            matrixA[i] = new int[listOfLists.get(i).size()];
        }
        for(int i=0; i<listOfLists.size(); i++){
            for (int j = 0; j < listOfLists.get(i).size(); j++) {
                matrixA[i][j] = listOfLists.get(i).get(j);
            }
        }*/

        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j]);
            }
            System.out.println();
        }
    }

}

