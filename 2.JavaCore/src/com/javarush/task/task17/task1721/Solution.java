package com.javarush.task.task17.task1721;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1 = reader.readLine();
            String f2 = reader.readLine();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(f1));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(f2));
            String line1;
            String line2;
            while ((line1 = bufferedReader1.readLine()) != null){
                allLines.add(line1);
            }

            while ((line2 = bufferedReader2.readLine()) != null){
                forRemoveLines.add(line2);
            }

            bufferedReader1.close();
            bufferedReader2.close();
        } catch(IOException e){

        }
    }

    public static void main(String[] args) throws IOException {
       try {
           new Solution().joinData();
       } catch (CorruptedDataException e){}

    }

    public  void joinData () throws CorruptedDataException {
        for (int i = 0; i < allLines.size(); i++) {
            for (int j = 0; j < forRemoveLines.size(); j++) {
                if (allLines.get(i).equals(forRemoveLines.get(j))) {
                    allLines.remove(i);
                }
            }
        }
        if (!allLines.isEmpty() && allLines.size() != forRemoveLines.size()) {
            allLines.clear();
            throw new CorruptedDataException();
               }
        }
    }




/*
C:\1.txt
C:\2.txt
        */
/*
/home/taye/Документи/1
/home/taye/Документи/2
*/
