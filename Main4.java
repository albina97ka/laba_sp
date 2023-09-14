import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // —читываем количество пар чисел
        input.nextLine(); // ѕереходим на новую строку, чтобы пропустить символ перевода строки после считывани€ числа N
        Map<Integer, Integer> votes = new HashMap<>(); // —оздаем Map дл€ хранени€ голосов (пар номер варианта - количествоголосов)
        for (int i = 0; i < n; i++) {
            int pairNumber = input.nextInt(); // —читываем номер варианта
            if (votes.containsKey(pairNumber)) {
                votes.put(pairNumber, votes.get(pairNumber) + 1); // ≈сли в Map уже есть запись с таким номером варианта, увеличиваем счетчик голосов на 1
            } else {
                votes.put(pairNumber, 1); // ¬ противном случае, добавл€ем новую запись с начальным значением 1
            }
        }
        input.close(); // «акрываем Scanner, так как ввод больше не нужен
        List<Map.Entry<Integer, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());
        Collections.sort(sortedVotes, (a, b) -> b.getValue().compareTo(a.getValue())); // —ортировка в пор€дке убывани€ голосов
        for (Map.Entry<Integer, Integer> entry : sortedVotes) { // ¬ыводим результаты подсчета голосов в пор€дке убывани€ количества голосов
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}