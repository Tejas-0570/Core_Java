public class MaxMin {
    public static void main(String[] args) {
        int[] arr = {3, 1, 9, 2, 7, 5};
        int max = arr[0]; //9
        int min = arr[0]; //1

        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        System.out.println("Maximum Value : "+max);
        System.out.println("Minimum Value : "+min);
    }
}
