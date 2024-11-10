class Solution {
    private String replace(String s, String oldSub, String newSub) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        int pos;
        
        while ((pos = s.indexOf(oldSub, start)) != -1) {
            result.append(s, start, pos);
            result.append(newSub);
            start = pos + oldSub.length();
        }
        
        result.append(s.substring(start));
        return result.toString();
    }

    public String makeFancyString(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : s.toCharArray()) {
            uniqueChars.add(ch);
        }

        for (char ch : uniqueChars) {
            String str10 = String.valueOf(ch).repeat(10);
            String str6 = String.valueOf(ch).repeat(6);
            String str4 = String.valueOf(ch).repeat(4);
            String str3 = String.valueOf(ch).repeat(3);
            String str2 = String.valueOf(ch).repeat(2);

            while (s.contains(str10)) s = replace(s, str10, str2);
            s = replace(s, str6, str2);
            s = replace(s, str4, str2);
            s = replace(s, str3, str2);
        }

        return s;
    }
}    