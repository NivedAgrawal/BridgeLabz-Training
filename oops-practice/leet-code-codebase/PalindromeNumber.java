public class Solution {
    public bool IsPalindrome(int x) {
       int p = 0,o=x;
       if(x<0) return false;
       while(x!=0){
        int k = x%10;
       p = p * 10 + k;
        x = x/10;
       } 
       if(p==o) return true;
       return false;
    }
}
