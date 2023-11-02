import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class photo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ������ �� ��������: ");
        String url = scanner.nextLine();

        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());

        System.out.println("������� �������� ��� �����: ");
        String name = scanner.nextLine();

        FileOutputStream fos = new FileOutputStream(name + ".jpg");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        System.out.println("�������� ������� ���������!");
    }
}