package ExamPrep.handball.repositories;

import ExamPrep.handball.entities.equipment.Equipment;

public interface Repository<E> {
    void add(Equipment equipment);
    boolean remove(Equipment equipment);
    Equipment findByType(String type);
}
