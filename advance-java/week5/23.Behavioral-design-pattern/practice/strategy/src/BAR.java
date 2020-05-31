class BAR extends StrategySearch{
    private int state = 1;
    @Override
    void preProcess() {
        System.out.println("Preprocess: ");
    }

    @Override
    boolean search() {
        System.out.println("Search-" + state++ + " ");
        return state == 3;
    }

    @Override
    void postProcess() {
        System.out.println("PostProcess: ");
    }
}
