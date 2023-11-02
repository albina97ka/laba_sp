import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¬ведите название песни: ");
        String name = scanner.nextLine();
        System.out.println("¬ведите ссылку на песню: ");
        String url = scanner.nextLine();

        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());

        FileOutputStream fos = new FileOutputStream(name + ".mp3");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}