package ExamPrep.climbers;

import ExamPrep.climbers.core.Controller;
import ExamPrep.climbers.core.ControllerImpl;
import ExamPrep.climbers.core.Engine;
import ExamPrep.climbers.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
