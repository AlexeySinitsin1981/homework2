package task2;

import java.util.HashMap;

public class MyMap {
    private static final int SIZE = 16;

    private Entry table[][] = new Entry[SIZE][SIZE];

    int count=0;


    public Entry get(Object k) {
        int column = k.hashCode() % SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][column].key.equals(k)) {
                return table[i][column];
            }
        }
        System.out.println("Объект не найден");
        return null;
    }

    public void remove(Object k) {
        int column = k.hashCode() % SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][column].key.equals(k)) {
                table[i][column] = null;
                count--;
                return;
            }
        }
        System.out.println("Объект удален");
    }

    public void add(Object k, Object v) {
        int column = k.hashCode() % SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][column] == null) {
                table[i][column] = new Entry(k, v);

            }
        }
        count++;
    }

    public boolean update(Object k, Object v) {
        int column = k.hashCode() % SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][column].key.equals(k)) {
                table[i][column] = new Entry(k, v);
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean checking(Object k) {
        int column = k.hashCode() % SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (table[i][column].key.equals(k)) {
                return true;
            }
        }
        return false;
    }

      public int getCount() {
        return count;
    }

        public static void main (String[]args){
            MyMap myHashMap = new MyMap();

            myHashMap.add("Audi", "Germany");
            myHashMap.add("Land-Rover", "England");
            myHashMap.add("Lada", "Russia");
            myHashMap.add("Fiat", "Italy");
            myHashMap.add("Ford", "USA");

            Entry e = myHashMap.get("Land-Rover");
            System.out.println("" + e.getValue());

            myHashMap.remove("Lada");

            myHashMap.update("Fiat", "Russia");
            Entry e2 = myHashMap.get("Fiat");
            System.out.println("" + e2.getValue());

            System.out.println(myHashMap.checking("Ford"));
            System.out.println(myHashMap.getCount());

        }
    }


