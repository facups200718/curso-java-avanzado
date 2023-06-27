package com.anncode.lambdas;

public class Main {
    public static void main(String[] args) {
        //La implementacion anonima de una functional interface y la lambda son lo mismo, pero la segunda es mas prolija.
        OnOneListener oneListener = new OnOneListener() {
            @Override
            public void onOne(String message) {
                System.out.println("One: " + message);
            }
        };

        OnOneListener oneListener2 = message ->
                System.out.println("One lambda :) " + message);

        oneListener.onOne("Sin lambda :(");
        oneListener2.onOne("Con lambda :)");
    }
}
