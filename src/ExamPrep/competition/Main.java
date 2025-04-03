package ExamPrep.competition;

import ExamPrep.competition.core.Controller;
import ExamPrep.competition.core.ControllerImpl;
import ExamPrep.competition.core.Engine;
import ExamPrep.competition.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}