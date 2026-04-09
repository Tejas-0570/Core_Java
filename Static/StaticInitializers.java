public class StaticInitializers {

    static double PI = 22.0/7.0;
    //Before actual execution above value first get executed and stored in PI = 3.142857142857143;
    //When main() call PI it just give value 3.142857142857143

    public static void main(String[] args) {
        System.out.println("PI : "+PI);
    }
}


/*
Syntax :

     Access_Modifier  Modifier  static datatype VariableName  =        Value       /  Expression;
e.g      public        final    static  double       PI       =  3.142857142857143 /   22.0/7;

Access modifier and modifier are optional.

 */