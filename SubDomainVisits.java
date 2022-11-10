package Zhenkai;

import java.util.*;

public class SubDomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : cpdomains) {
            int pos = 0, cnt = 0;
            int len = str.length();
            while (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                cnt *= 10;
                cnt += str.charAt(pos++) - '0';
            }
            while (str.charAt(pos) == ' ') {
                pos++;
            }
            int begin = pos;
            while (pos <= len) {
                if (pos == len || str.charAt(pos) == '.') {
                    String key = str.substring(begin, len);
                    if (map.containsKey(key)) {
                        map.put(key, map.getOrDefault(key, 0) + cnt);
                    } else {
                        map.put(key, cnt);
                    }
                    begin = pos + 1;
                }
                pos++;
            }
        }
        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, Integer> me : map.entrySet()) {
            resList.add(me.getValue() + " " + me.getKey());
        }

        return resList;
    }
}
