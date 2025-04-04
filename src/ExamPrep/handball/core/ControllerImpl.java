package ExamPrep.handball.core;

import ExamPrep.handball.common.ConstantMessages;
import ExamPrep.handball.common.ExceptionMessages;
import ExamPrep.handball.entities.equipment.ElbowPad;
import ExamPrep.handball.entities.equipment.Equipment;
import ExamPrep.handball.entities.equipment.Kneepad;
import ExamPrep.handball.entities.gameplay.Gameplay;
import ExamPrep.handball.entities.gameplay.Indoor;
import ExamPrep.handball.entities.gameplay.Outdoor;
import ExamPrep.handball.entities.team.Bulgaria;
import ExamPrep.handball.entities.team.Germany;
import ExamPrep.handball.entities.team.Team;
import ExamPrep.handball.repositories.EquipmentRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private EquipmentRepository equipmentRepository;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipmentRepository = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay;
        switch (gameplayType){
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }
        gameplays.add(gameplay);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment;
        switch (equipmentType){
            case "Kneepad":
                equipment = new Kneepad();
                break;
            case "ElbowPad":
                equipment = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }
        equipmentRepository.add(equipment);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipment.getClass().getSimpleName());
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipment = equipmentRepository.findByType(equipmentType);
        if (equipment == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }
        equipmentRepository.remove(equipment);
        for (Gameplay gameplay : gameplays) {
            if (gameplay.getName().equals(gameplayName)){
                gameplay.addEquipment(equipment);
                break;
            }
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team;
        switch (teamType){
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TEAM_TYPE);
        }
        for (Gameplay gameplay : gameplays) {
            if (gameplay.getName().equals(gameplayName)){
                String gameplayType = gameplay.getClass().getSimpleName();
                String teamCountry = team.getClass().getSimpleName();
                if ((teamCountry.equals("Bulgaria") && gameplayType.equals("Indoor")) ||
                        (teamCountry.equals("Germany") && gameplayType.equals("Outdoor"))){
                    return ConstantMessages.GAMEPLAY_NOT_SUITABLE;
                }
                else{
                    gameplay.addTeam(team);
                    return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
                }
            }
        }
        return "";
    }

    @Override
    public String playInGameplay(String gameplayName) {
        for (Gameplay gameplay : gameplays) {
            if (gameplay.getName().equals(gameplayName)){
                gameplay.teamsInGameplay();
                return String.format(ConstantMessages.TEAMS_PLAYED, gameplay.getTeam().size());
            }
        }
        return "";
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        int advantages = 0;
        for (Gameplay gameplay : gameplays) {
            if (gameplay.getName().equals(gameplayName)){
                for (Team team : gameplay.getTeam()) {
                    advantages += team.getAdvantage();
                }
                break;
            }
        }
        return String.format(ConstantMessages.ADVANTAGE_GAMEPLAY, gameplayName, advantages);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Gameplay gameplay : gameplays) {
            stringBuilder.append(gameplay).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
