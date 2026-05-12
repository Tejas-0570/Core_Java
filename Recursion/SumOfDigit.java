public class SumOfDigit {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println("Sum : "+sum(n));
    }

    public static int sum(int num){
        if(num != 0){
            return (num%10) + sum(num /= 10);
        } else {
            return num;
        }
    }
}
