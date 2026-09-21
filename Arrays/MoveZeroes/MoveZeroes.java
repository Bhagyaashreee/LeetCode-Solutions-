package MoveZeroes;

class Solution{
    public void moveZeroes(int[] nums){
        //T O(n) S O(1)
        //[0,1,3,0,12]
        //     i
        // j
        int j=0;
        for(int i=0;i<nums.length;i++){
        //     if(nums[i] != 0){
        //         nums[j]=nums[i];
        //         j++;
        //     }
        // }
        // while(j<nums.length){
        //     nums[j]=0;
        //     j++;
        //[1,3,0,0,12]
        //       i
        //   j
        //temp=1//temo=3
               if(nums[i] !=0){
                int temp=nums[i];
                nums[i]=0;
                nums[j]=temp;
                j++;
               }
        }
    }
}
