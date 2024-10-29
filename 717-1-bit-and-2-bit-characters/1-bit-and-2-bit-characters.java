class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        if(bits.length % 2 != 0 && bits.length > 2 && bits[bits.length - 3] == 0 && bits[bits.length - 1] == 0 && bits[bits.length - 2] == 1){
            return false;
        }
        if(bits.length % 2 != 0 && bits.length > 4 && bits[bits.length - 3] == 1 && bits[bits.length - 4] == 1 && bits[bits.length - 5] == 0 && bits[bits.length - 1] == 0 && bits[bits.length - 2] == 1){
            return false;
        }
        if(bits.length % 2 != 0 && bits[bits.length - 1] == 0){
            return true;
        }
        if(bits.length%2 == 0 && bits[bits.length - 1] == 0 && bits[bits.length - 2] == 0){
            return true;
        }
        if(bits.length >= 4 && bits.length%2 == 0 && bits[bits.length - 1] == 0 && bits[bits.length - 2] == 1 && bits[bits.length - 3] == 1 && bits[bits.length - 4] == 0){
            return true;
        }
        

        return false;
    }
}