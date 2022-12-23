package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;
    public Balls(List<Integer> arrayBalls) {
        List<Ball> balls =  mapTo(arrayBalls);
        this.answers = balls;
    }

    private List<Ball> mapTo(List<Integer> arrayBalls) {
        List<Ball> balls= new ArrayList<>();
        for(int i=0; i<arrayBalls.size(); i++){
            balls.add(new Ball(i, arrayBalls.get(i)));
        }
       return balls;
    }

    public PlayResult play(List<Integer> balls){
        Balls userBalls = new Balls(balls);
        PlayResult result = new PlayResult();
        for (Ball answer : answers){
            BallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }

    public BallStatus play(Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
