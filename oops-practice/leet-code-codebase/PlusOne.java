class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        if(digits[len-1]<9){
            digits[len-1]+=1;
            }
        else{
            digits[len-1]=0;
            int c=1;
            for(int i=len-2;i>=0;i--){
                if(c+digits[i]>9){
                    digits[i]=0;
                }
                else{
                    digits[i]+=c;
                    c=0;
                    break;
                }
            }
            if(c==1){
                int[] a=new int[len+1];
                a[0]=1;
                return a;
                }
        }
        return digits;    
    }
}
