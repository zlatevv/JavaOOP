package ExamPrep.picking;

import ExamPrep.picking.core.Controller;
import ExamPrep.picking.core.ControllerImpl;
import ExamPrep.picking.core.Engine;
import ExamPrep.picking.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}