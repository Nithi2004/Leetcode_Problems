class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTmpIdx = -1;

        while (sIdx < sLen) {
            // Case 1: Characters match or '?' matches any single character
            if (pIdx < pLen && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')) {
                sIdx++;
                pIdx++;
            }
            // Case 2: '*' matches zero or more characters
            else if (pIdx < pLen && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                sTmpIdx = sIdx;
                pIdx++;
            }
            // Case 3: Mismatch and backtrack to last '*'
            else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sTmpIdx++;
                sIdx = sTmpIdx;
            }
            // Case 4: No match possible
            else {
                return false;
            }
        }

        // Check remaining characters in pattern are '*'
        while (pIdx < pLen && p.charAt(pIdx) == '*') {
            pIdx++;
        }

        return pIdx == pLen;
    }
}