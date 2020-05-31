public class FOO extends StrategySolution{
    private int state = 1;
    @Override
    protected void start() {
        System.out.println("Start ");
    }

    @Override
    protected boolean nextTry() {
        System.out.println("Next try-" + state++ + " ");
        return true;
    }

    @Override
    protected boolean isSolution() {
        System.out.println("IsSolution-" + (state == 3) + " ");
        return (state == 3);
    }

    @Override
    protected void stop() {
        System.out.println("Stop");
    }
}
