import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class photo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ссылку на картинку: ");
        String url = scanner.nextLine();

        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());

        System.out.println("Введите название для файла: ");
        String name = scanner.nextLine();

        FileOutputStream fos = new FileOutputStream(name + ".jpg");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

        System.out.println("Картинка успешно сохранена!");
    }
}