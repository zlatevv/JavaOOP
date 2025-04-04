package ExamPrep.handball.entities.gameplay;

import ExamPrep.handball.common.ExceptionMessages;
import ExamPrep.handball.entities.equipment.Equipment;
import ExamPrep.handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class BaseGameplay implements Gameplay{
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int allProtection() {
        int sum = 0;
        for (Equipment equipment : this.equipments) {
            sum += equipment.getProtection();
        }
        return sum;
    }

    @Override
    public void addTeam(Team team) {
        this.teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        this.teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        for (Team team : teams) {
            team.play();
        }
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String teamNames = teams.isEmpty()
                ? "none"
                : teams.stream()
                .map(Team::getName)
                .collect(Collectors.joining(" "));

        return String.format("%s %s%n" +
                        "Team: %s%n" +
                        "Equipment: %d, Protection: %d",
                name,
                this.getClass().getSimpleName(),
                teamNames,
                equipments.size(),
                allProtection());
    }
}
