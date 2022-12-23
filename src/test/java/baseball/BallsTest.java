package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName("nothing")
    public void nothing(){
        Balls answer = new Balls(Arrays.asList(1,2,3)); //answer
        PlayResult playResult = answer.play(Arrays.asList(4,5,6));
        assertThat(playResult.getStrike()).isEqualTo(0);
        assertThat(playResult.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1ball")
    public void play_1ball(){
        Balls answer = new Balls(Arrays.asList(1,2,3)); //answer
        PlayResult playResult = answer.play(Arrays.asList(2,4,5));
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("1ball 1strike")
    public void play_1ball_3strike(){
        Balls answer = new Balls(Arrays.asList(1,2,3)); //answer
        PlayResult playResult = answer.play(Arrays.asList(2,4,3));
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("3strike")
    public void play_3strike(){
        Balls answer = new Balls(Arrays.asList(1,2,3)); //answer
        PlayResult playResult = answer.play(Arrays.asList(1,2,3));
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
        assertThat(playResult.isGameEnd()).isTrue();
    }
}
