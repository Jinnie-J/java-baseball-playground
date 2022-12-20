package study;

public class Calculator {
    int add(int i, int j){
        return i+j;
    }
    int subtract(int i, int j){
        return i-j;
    }
    int multiply(int i, int j){
        return i*j;
    }
    int divide(int i, int j){
        return i/j;
    }

    public int calculate(int firstValue, char operator, int secondValue){
        if(operator=='+'){
            return add(firstValue, secondValue);
        }
        if(operator =='-'){
            return subtract(firstValue, secondValue);
        }
        if(operator =='*'){
            return multiply(firstValue , secondValue);
        }
        if(operator=='/'){
            return divide(firstValue, secondValue);
        }
        else System.out.println("잘못된 입력값");
        throw new RuntimeException();
    }

    public String[] separate(String value){
        return value.split(" ");
    }

    public int toInt(String value){
        return Integer.parseInt(value);
    }

    public int calculateString(String[] str){
        int result = toInt(str[0]);
        for(int i=0; i< str.length-2; i+=2){
            result = calculate(result ,str[i+1].charAt(0), toInt(str[i+2]));
        }
        return result;
    }
}
