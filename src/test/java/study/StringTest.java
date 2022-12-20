package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void split(){
        String test = "1,2";
        String[] arr = test.split(",");
        assertThat(arr).contains("1");
    }
    @Test
    void splitExactly(){
        String test = "1";
        String[] arr = test.split("1");
        assertThat(arr).containsExactly("1");
    }
    @Test
    void substring(){
        String test1 = "(1,2)";
        String test2 = test1.substring(1,test1.length()-1);
        assertThat(test2).isEqualTo("1,2");
    }
    @Test
    void charAt(){
        String str = "abc";
        int index = 10;
        assertThatThrownBy(() -> {
            char exceptionCode = str.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
