import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String inputStr = scanner.nextLine();

        DFA dfa = new DFA();
        dfa.recognitDFA(inputStr);
    }
}
