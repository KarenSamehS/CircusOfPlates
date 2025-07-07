package Controller;

public class ModerateLevel implements Strategy {

    @Override
    public int getTimeout() {
        return 1;
    }

    @Override
    public int getSpeed() {
        return 20;
    }

}

