package ExamPrep.harpoonDiver;

import ExamPrep.harpoonDiver.core.Controller;
import ExamPrep.harpoonDiver.core.ControllerImpl;
import ExamPrep.harpoonDiver.core.Engine;
import ExamPrep.harpoonDiver.core.EngineImpl;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
