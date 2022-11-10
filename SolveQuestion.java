package Shibing;

public class SolveQuestion {
    public String solveEquation(String equation) {
        int index = -1;
        equation = equation.replace("-", "+-");
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                index = i;
                break;
            }
        }
        //µÈºÅ×ó±ß
        String leftEqual = equation.substring(0, index);
        //µÈºÅÓÒ±ß
        String rightEqual = equation.substring(index + 1);
        String[] left = leftEqual.split("\\+");
        String[] right = rightEqual.split("\\+");
        int[] leftNum = getNum(left);
        int[] rightNum = getNum(right);
        int x = leftNum[0] - rightNum[0];
        int num = leftNum[1] - rightNum[1];
        if (x == 0) {
            if (num == 0) return "Infinite solutions";
            else return "No solution";
        } else return "x=" + (-num / x);
    }

    private int[] getNum(String[] strs) {
        int xTotal = 0;
        int numTotal = 0;
        for (String str : strs) {
            if (str.equals("")) continue;
            else if (str.contains("x")) {
                if (str.length() == 1) {
                    xTotal++;
                } else if (str.length() == 2 && str.charAt(0) == '-') {
                    xTotal--;
                } else {
                    String left = str.substring(0, str.length() - 1);
                    xTotal += Integer.parseInt(left);
                }
            } else numTotal += Integer.parseInt(str);
        }
        return new int[]{xTotal, numTotal};
    }
}
