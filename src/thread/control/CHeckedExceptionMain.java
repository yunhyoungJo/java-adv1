package thread.control;

public class CHeckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable{

        @Override
        public void run() {
            //throw new Exception();
        }
    }
}
