package com.company;

public class MoreThreads2 implements Runnable{
    static Thread thread;
    MoreThreads2(String name){
        thread = new Thread(this,name);
    }
    public static MoreThreads2 createAndStart(String name ){
        MoreThreads2 moreThreads2 = new MoreThreads2(name);
        MoreThreads2.thread.start();
        return  moreThreads2;
    }

    public  void run(){
        System.out.println(thread.getName()+"rozpoczyna dzialanie ");
        try{
            for(int count=0;count<10;count++){
                Thread.sleep(400);
                System.out.println(thread.getName()+"jest wykonowany , wartość licznika "+count);
            }
        }catch (InterruptedException e){
            System.out.println(thread.getName()+"Został przerwany");
        }
        System.out.println(thread.getName()+"kończy działanie");
    }
}
class MoreThread{


    public static void main(String[] args) {
        MoreThreads2 moreThreads1 = MoreThreads2.createAndStart("Wyjątek potomny nr 1");
        MoreThreads2 moreThreads2 = MoreThreads2.createAndStart("Wyjątek potomny nr 2");
        MoreThreads2 moreThreads3 = MoreThreads2.createAndStart("Wyjątek potomny nr 3");

        System.out.print(".");
        try {
            Thread.sleep(100);
            moreThreads1.thread.join();
            moreThreads2.thread.join();
            moreThreads3.thread.join();

        }catch (InterruptedException e){
            System.out.println("Wątek główny został przerwany");
        }
    }
}
