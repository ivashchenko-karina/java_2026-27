package org.example.abstraction;

public interface Playable {
    void play();

    class Guitar implements Playable{
        @Override
        public void play(){
            System.out.println("Гітара грає");
        }
    }
    class Piano implements Playable{
        @Override
        public void play(){
            System.out.println("Піаніно грає");
        }
    }

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }

}
