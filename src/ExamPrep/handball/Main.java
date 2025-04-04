package ExamPrep.handball;

import ExamPrep.handball.core.Engine;
import ExamPrep.handball.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
