package Controller;

public class EasyLevel implements Strategy{

    @Override
    public int getTimeout() {
        return 2;
    }

    @Override
    public int getSpeed() {
        return 30;
    }

}

