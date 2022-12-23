package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;


    public void report(BallStatus status){
        if(status.isStrike()){
            this.strike +=1;
        }
        if(status.isBall()){
            this.ball +=1 ;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public Boolean isGameEnd(){
        return this.strike ==3;
    }
}
