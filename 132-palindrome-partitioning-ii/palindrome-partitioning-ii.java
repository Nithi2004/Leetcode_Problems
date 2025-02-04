class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] solvetilln = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            solvetilln[i] = n - i - 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            // For odd-length
            // i-j is 1st pointer, i+j is 2nd pointer
            for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++) {
                solvetilln[i - j] = Math.min(solvetilln[i - j], 1 + solvetilln[i + j + 1]);
            }
            // For even-length
            // i-j is 1st pointer, i+j+1 is 2nd pointer
            for (int j = 0; i - j >= 0 && i + j + 1 < n && s.charAt(i - j) == s.charAt(i + j + 1); j++) {
                solvetilln[i - j] = Math.min(solvetilln[i - j], 1 + solvetilln[i + j + 2]);
            }
        }
        return solvetilln[0];
    }
}