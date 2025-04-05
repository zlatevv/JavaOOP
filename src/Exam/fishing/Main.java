package Exam.fishing;

import Exam.fishing.core.Controller;
import Exam.fishing.core.ControllerImpl;
import Exam.fishing.core.Engine;
import Exam.fishing.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}