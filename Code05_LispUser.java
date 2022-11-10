package Shibing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code05_LispUser {

    public int evaluate(String expression) {
        return help(new HashMap<>(),expression);
    }

    public int help(Map<String, String> map, String expression) {
        String op = expression.substring(0, expression.indexOf(' '));
        int cnt = 0;
        int li = -1;
        List<String> vs = new ArrayList<>();
        //从 (let 后面开始计算
        for (int i = op.length(); i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') continue;
            if (c == '(') {
                cnt++;
                if (li == -1) li = i;
            } else if (c == ')') {
                cnt--;
                if (cnt == 0) {
                    String sub = expression.substring(li, i + 1);
                    li = -1;
                    //sub 是 let 还是 mult/add
                    if (sub.startsWith("(let")) vs.add(String.valueOf(help(new HashMap<>(map), sub)));
                    else vs.add(String.valueOf(help(new HashMap<>(map), sub)));
                    if (op.equals("(let") && vs.size() % 2 == 0) map.put(vs.get(vs.size() - 2), vs.get(vs.size() - 1));
                }
            } else if (cnt == 0) {
                //认定是个变量或者是个值
                int j = i;
                while (expression.charAt(j) != ' ' && expression.charAt(j) != ')') j++;
                String e = expression.substring(i, j);
                if (vs.size() % 2 != 0) vs.add(map.getOrDefault(e, e));
                else vs.add(e);
                if (op.equals("(let") && vs.size() % 2 == 0) map.put(vs.get(vs.size() - 2), vs.get(vs.size() - 1));
                i = j;
            }
        }
        if (op.equals("(let")) {
            // 从let开始识别
            String last = vs.get(vs.size() - 1);
            return Integer.parseInt(map.getOrDefault(last, last));
        }
        // 从list当中提取题意中的元素加入add中
        int v1 = Integer.parseInt(map.getOrDefault(vs.get(0), vs.get(0)));
        int v2 = Integer.parseInt(map.getOrDefault(vs.get(1), vs.get(1)));
        return op.equals("(add") ? v1 + v2 : v1 * v2;
    }
}

