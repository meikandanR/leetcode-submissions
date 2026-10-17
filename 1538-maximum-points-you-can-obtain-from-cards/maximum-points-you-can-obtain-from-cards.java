class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        for(int i =0; i< k;i++){
            leftSum += cardPoints[i];
        }
        int maxSum = leftSum;

        int rightSum = 0;
        int l=k-1;

        for(int r = cardPoints.length-1 ; r>=cardPoints.length-k;r--){

            leftSum = leftSum-cardPoints[l];
            rightSum += cardPoints[r];
            l--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;

    }
}