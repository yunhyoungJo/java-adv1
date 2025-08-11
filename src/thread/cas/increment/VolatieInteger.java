package thread.cas.increment;

public class VolatieInteger implements IncrementInteger{

    private volatile int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
