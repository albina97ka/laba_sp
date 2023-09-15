public class Main7 {
    public static void main(String[] args) {
        Thread chickenThread = new Thread(new Chicken());
        Thread eggThread = new Thread(new Egg());
        chickenThread.start();
        eggThread.start();
        try {
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Chicken.lastWord.equals("Курица")) {
            System.out.println("Победила курица!");
        } else {
            System.out.println("Победило яйцо!");
        }
    }
}
class Chicken implements Runnable {
    static String lastWord = "";

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lastWord = "Курица";
        System.out.println("Курица");
    }
}
class Egg implements Runnable {
    static String lastWord = "";
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastWord = "Яйцо";
        System.out.println("Яйцо");
    }
}