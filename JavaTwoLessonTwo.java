package Java2;

import java.util.Random;

class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size){
        this.size = 0;
        this.arr = new int[size];
    }

    public void display(){
        for(int i = 0; i < this.size; i++) {
            System.out.print(this.arr[i]+" ");
        }
    }

       public void delete(int value){
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }

        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    public void insert(int value){
        this.arr[this.size] = value;
        this.size++;
    }
    public boolean find(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    private void change(int a, int b){
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;

    }
    public void sortBubble(){
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (this.arr[in] > this.arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }


    public void sortSelect(){
        int out, in, mark;
        for(out=0;out<this.size;out++){
            mark = out;
            for(in = out+1;in<this.size;in++){
                if (this.arr[in]< this.arr[mark]){
                    mark = in;
                }
            }
            change(out, mark);
        }
    }


    public void sortInsert(){
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = this.arr[out];
            in = out;
            while(in > 0 && this.arr[in-1] >=temp){
                this.arr[in] = this.arr[in-1];
                --in;
            }
            this.arr[in] = temp;
        }
    }

}




public class Main {
    public static void main(String[] args) {
        MyArr arr = new MyArr(100000);
        Random rand = new Random();
        for (int i = 0; i < 100000 ; i++) {
            arr.insert(rand.nextInt(10000));
        }

        long t1 = System.nanoTime();
        arr.sortBubble();
        //arr.sortInsert();
       // arr.sortSelect();
        long t2= (System.nanoTime()-t1)/1000000000;
        System.out.println("Time spent in sec: " + t2);
    }
}

