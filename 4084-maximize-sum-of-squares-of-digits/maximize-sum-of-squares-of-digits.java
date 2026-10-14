class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        // A single digit can be at most 9. 
        // If the required sum exceeds the maximum possible sum, it's impossible.
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        // Greedily append as many 9s as possible
        int nines = sum / 9;
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }

        // Append the remaining remainder digit if any
        int remainder = sum % 9;
        if (sb.length() < num && remainder > 0) {
            sb.append(remainder);
        }

        // Fill up the rest of the available positions with 0s
        while (sb.length() < num) {
            sb.append('0');
        }

        return sb.toString();
    
    }
}

