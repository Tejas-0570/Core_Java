public class AdditionOfPrevAndNext {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int[] sum = new int[5];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i == 0){
                    sum[i] = arr[i] + arr[i+1];
                } else if (i == arr.length-1) {
                    sum[i] = arr[i-1] + arr[i];
                } else {
                    sum[i] = arr[i-1] + arr[i+1];
                }
            }
        }

        for (int i = 0; i < sum.length; i++){
            System.out.print(sum[i]+" ");
        }

    }
}
