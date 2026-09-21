package PlusOne;
class Solution {
   public int[] plusOne(int[] digits){
    //digits = [4,3,2,1]
    //                i
    //[4,3,2,2]
    //[9,9]
    //[1,0,0] res=new int[digits.length+1];res[0]=1
    for(int i=digits.length-1;i>=0;i--){
        if(digits[i]==9){
            digits[i]=0;
        }else{
            digits[i]=digits[i]+1;
            return digits;
        }
    }
    int[] res=new int[digits.length+1];
    res[0]=1;
    return res;
   }
}