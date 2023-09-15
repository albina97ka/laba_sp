class AnimalThread extends Thread {
    private String name;
    private int priority;
    private int distance;
    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.distance = 0;
    }
    public void changePriority(int newPriority) {
        this.priority = newPriority;
        setPriority(newPriority);
        System.out.println(name + " изменяет приоритет на " + newPriority);
    }
    public void run() {
        while (distance < 100) {
            distance += 10;
            System.out.println(name + " преодолел " + distance + " метров.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " финишировал!");
    }
}
public class Main6 {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY);

        rabbit.start();
        turtle.start();

        try {
            Thread.sleep(3000); // Задержка для демонстрации
            rabbit.changePriority(Thread.MAX_PRIORITY);
            turtle.changePriority(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
