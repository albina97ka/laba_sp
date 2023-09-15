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
        System.out.println(name + " �������� ��������� �� " + newPriority);
    }
    public void run() {
        while (distance < 100) {
            distance += 10;
            System.out.println(name + " ��������� " + distance + " ������.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " �����������!");
    }
}
public class Main6 {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("������", Thread.MAX_PRIORITY);
        AnimalThread turtle = new AnimalThread("��������", Thread.MIN_PRIORITY);

        rabbit.start();
        turtle.start();

        try {
            Thread.sleep(3000); // �������� ��� ������������
            rabbit.changePriority(Thread.MAX_PRIORITY);
            turtle.changePriority(Thread.MIN_PRIORITY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
