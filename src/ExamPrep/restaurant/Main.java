package ExamPrep.restaurant;

import ExamPrep.restaurant.core.Controller;
import ExamPrep.restaurant.core.ControllerImpl;
import ExamPrep.restaurant.core.Engine;
import ExamPrep.restaurant.core.EngineImpl;

public class Main {

    public static void main(String[] args) {

       Controller controller = new ControllerImpl();
       Engine engine = new EngineImpl(controller);
       engine.run();
    }
}
