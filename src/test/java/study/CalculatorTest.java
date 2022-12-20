package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("더하기 테스트")
    void addTest(){
        int result = calculator.add(3,4);
        assertThat(result).isEqualTo(7);

    }
    @Test
    @DisplayName("빼기 테스트")
    void subtractTest(){
        int result = calculator.subtract(4,3);
        assertThat(result).isEqualTo(1);

    }
    @Test
    @DisplayName("곱하기 테스트")
    void multiplytest(){
        int result = calculator.multiply(4,3);
        assertThat(result).isEqualTo(12);

    }
    @Test
    @DisplayName("나누기 테스트")
    void divideTest(){
        int result = calculator.divide(4,1);
        assertThat(result).isEqualTo(4);

    }
    @Test
    @DisplayName("문자열 배열로 나누기 테스트")
    void separate(){
        String value = "1 + 3";
        String[] result = {"1","+","3"};
        assertThat(result).isEqualTo(calculator.separate(value));
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2, 10, true", "2 + 3 * 4 / 2, 8, false"})
    @DisplayName("문자열 계산기 테스트")
    void calculate(String str, Integer number, Boolean result){
        String[] valueArr = calculator.separate(str);
        int answer = calculator.calculateString(valueArr);
        assertThat(number.equals(answer)).isEqualTo(result);
    }
}
