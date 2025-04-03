package ExamPrep.picking.core;

import ExamPrep.picking.entities.action.Action;
import ExamPrep.picking.entities.action.ActionImpl;
import ExamPrep.picking.entities.pickers.ExperiencedPicker;
import ExamPrep.picking.entities.pickers.JuniorPicker;
import ExamPrep.picking.entities.pickers.Picker;
import ExamPrep.picking.entities.places.Place;
import ExamPrep.picking.entities.places.PlaceImpl;
import ExamPrep.picking.repositories.PlaceRepository;

import java.util.Arrays;

import static ExamPrep.picking.common.ConstantMessages.*;
import static ExamPrep.picking.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private PlaceRepository placeRepository;
    private Action action;
    public ControllerImpl() {
        this.placeRepository = new PlaceRepository();
        this.action = new ActionImpl();
    }

    @Override
    public String addPlace(String placeName, String... mushrooms) {
        Place place = new PlaceImpl(placeName);
        place.getMushrooms().addAll(Arrays.asList(mushrooms));
        placeRepository.add(place);
        return String.format(PLACE_ADDED, placeName);
    }

    @Override
    public String addPicker(String placeName, String pickerType, String pickerName) {
        Place place = placeRepository.byName(placeName);
        for (Picker picker : place.getPickers()) {
            if (picker.getName().equals(pickerName)){
                throw new IllegalArgumentException(EXISTING_PICKER);
            }
        }
        Picker picker;
        switch (pickerType) {
            case "ExperiencedPicker":
                picker = new ExperiencedPicker(pickerName);
                break;
            case "JuniorPicker":
                picker = new JuniorPicker(pickerName);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PICKER);
        }
        place.getPickers().add(picker);
        return String.format(PICKER_ADDED, pickerType, pickerName);
    }

    @Override
    public String startPicking(String placeName) {
        if (placeRepository.byName(placeName) == null){
            throw new NullPointerException(String.format(NON_EXISTING_PLACE, placeName));
        }
        Place place = placeRepository.byName(placeName);
        action.startPicking(place);
        return String.format(PLACE_VISITED, placeName);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Place place : placeRepository.getCollection()) {
            stringBuilder.append(String.format("Pickers in the %s:%n", place.getName()));
            for (Picker picker : place.getPickers()) {
                stringBuilder.append(String.format("Name: %s%n", picker.getName()));
                stringBuilder.append(String.format("Vitality: %d%n", picker.getVitality()));
                if (picker.getBag().getMushrooms().isEmpty()){
                    stringBuilder.append("Bag mushrooms: none").append(System.lineSeparator());
                }else{
                    stringBuilder.append(String.format("Bag mushrooms: %s%n",
                            String.join(", ", picker.getBag().getMushrooms())));
                }
            }
        }
        return stringBuilder.toString();
    }
}
