package com.java.training.nov_19;

class Gaurav extends Thread{
    Resource resource;

    public Gaurav(Resource resource) {
        this.resource = resource;
    }
    public void run(){
        resource.displayMsg("Gaurav");
    }
}
class Nikhil extends Thread{
    Resource resource;

    public Nikhil(Resource resource) {
        this.resource = resource;
    }
    public void run(){
        resource.displayMsg("Nikhil ");
    }
}

class Sujit extends Thread{
    Resource resource;

    public Sujit(Resource resource) {
        this.resource = resource;
    }
    public void run(){
        resource.displayMsg("Sujit ");
    }
}
class Resource {
    synchronized void displayMsg(String name){
        System.out.println("Hello " + name);
        try {
            Thread.sleep(1000);
            System.out.println("How are you");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class SynchronizationEx2 {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Gaurav gaurav = new Gaurav(resource);
        Nikhil nikhil = new Nikhil(resource);
        Sujit sujit = new Sujit(resource);


        gaurav.start();
        nikhil.start();
        sujit.start();
    }
}
