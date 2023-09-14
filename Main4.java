import java.util.*;
public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // ��������� ���������� ��� �����
        input.nextLine(); // ��������� �� ����� ������, ����� ���������� ������ �������� ������ ����� ���������� ����� N
        Map<Integer, Integer> votes = new HashMap<>(); // ������� Map ��� �������� ������� (��� ����� �������� - �����������������)
        for (int i = 0; i < n; i++) {
            int pairNumber = input.nextInt(); // ��������� ����� ��������
            if (votes.containsKey(pairNumber)) {
                votes.put(pairNumber, votes.get(pairNumber) + 1); // ���� � Map ��� ���� ������ � ����� ������� ��������, ����������� ������� ������� �� 1
            } else {
                votes.put(pairNumber, 1); // � ��������� ������, ��������� ����� ������ � ��������� ��������� 1
            }
        }
        input.close(); // ��������� Scanner, ��� ��� ���� ������ �� �����
        List<Map.Entry<Integer, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());
        Collections.sort(sortedVotes, (a, b) -> b.getValue().compareTo(a.getValue())); // ���������� � ������� �������� �������
        for (Map.Entry<Integer, Integer> entry : sortedVotes) { // ������� ���������� �������� ������� � ������� �������� ���������� �������
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}