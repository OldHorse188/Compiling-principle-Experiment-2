public class DFA {

    // 初态
    private char startState;
    // 符号集
    private char[] symbol;
    // 状态集
    private char[] state;
    // 规则矩阵
    private char[][] ruleMatrix;
    // 终态
    private char[] endState;

    public DFA() {
        this.startState = '1';
        this.symbol = new char[] {'a','b','c','d'};
        this.state = new char[] {'1', '2', '3','4', '5', '6','7'};
        this.ruleMatrix = new char[][]{
                {'3','2',' ',' '},
                {'4','2',' ',' '},
                {' ','6','3','5'},
                {' ','7','3','5'},
                {'4',' ',' ',' '},
                {' ','6',' ',' '},
                {' ','6',' ',' '}
        };
        this.endState = new char[] { '6','7' };
    }

    // 根据当前状态和下一个字符，则返回下一个状态
    public char switchState(char nowState, char nextSymbol) {
        int m = -1, n = -1;
        for (int i = 0; i < state.length; i++) {
            if (nowState == state[i]) {
                m = i;
                break;
            }
        }
        for (int j = 0; j < symbol.length; j++) {
            if (nextSymbol == symbol[j]) {
                n = j;
                break;
            }
        }
        if (n == -1 || m == -1) {
            return '0';
        }
        return ruleMatrix[m][n];
    }

    // 字符串识别
    public boolean recognitDFA(String inputStr) {

        char currState = getStartState();

        for (int i = 0; i < inputStr.length(); i++) {
            currState = switchState(currState, inputStr.charAt(i));
            if (currState == '0') {
                System.out.println("输入错误！出错位置为：" + (i+1) +" \'"+ inputStr.charAt(i) + "\'");
                System.exit(0);
            }
        }

        // 判断是否到达终态
        boolean flag = false;
        for(int k = 0; k < getEndState().length; k++){
            if(currState == getEndState()[k]){
                flag = true;
                break;
            }
        }

        if(flag)
            System.out.println("DFA识别通过");
        else
            System.out.println("DFA无法识别");

        return flag;
    }

    public char getStartState() {
        return startState;
    }

    public char[] getSymbol() {
        return symbol;
    }

    public char[] getState() {
        return state;
    }

    public char[][] getRuleMatrix() {
        return ruleMatrix;
    }

    public char[] getEndState() {
        return endState;
    }
}