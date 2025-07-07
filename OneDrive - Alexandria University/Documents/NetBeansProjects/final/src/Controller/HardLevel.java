package Controller;

public class HardLevel  implements Strategy{

    @Override
    public int getTimeout() {
        return 1;
    }

    @Override
    public int getSpeed() {
        return 10;
    }
}

