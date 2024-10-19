class Solution {
    public String longestNiceSubstring(String s) {
        int [] index = longestNiceSubstring(s, 0, s.length());
        return s.substring(index[0], index[1]);
    }

    private int [] longestNiceSubstring(String s, int start, int end) {
        for(int i = start; i < end; i++) {
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch) && s.substring(start, end).contains(Character.toUpperCase(ch) + "")) continue;
            else if(Character.isUpperCase(ch) && s.substring(start, end).contains(Character.toLowerCase(ch) + "")) continue;

            int [] first = longestNiceSubstring(s, start, i);
            int [] second = longestNiceSubstring(s, i + 1, end);

            if(first[1] - first[0] >= second[1] - second[0]) {
                return first;
            } else {
                return second;
            }
        }

        return new int[] {start, end};
    }
}