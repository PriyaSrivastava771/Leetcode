class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder result = new StringBuilder();

            int count = 1;

            for (int j = 1; j < s.length(); j++) {

                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++;
                } else {
                    result.append(count);
                    result.append(s.charAt(j - 1));
                    count = 1;
                }
            }

            result.append(count);
            result.append(s.charAt(s.length() - 1));

            s = result.toString();
        }

        return s;
    }
}