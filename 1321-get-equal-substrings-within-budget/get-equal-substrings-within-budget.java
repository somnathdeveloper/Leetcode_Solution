class Solution {
  public int equalSubstring(String s, String t, int maxCost) {
    var len = 0;
    var cost = 0;
    var i = 0;
    var j = 0;

    while (j < s.length()) {
      if (cost <= maxCost) {
        cost += Math.abs(s.charAt(j) - t.charAt(j));
        j++;
      }
      while (cost > maxCost) {
        cost -= Math.abs(s.charAt(i) - t.charAt(i));
        i++;
      }
      len = Math.max(len, j-i);
    }
    return len;
  }
}