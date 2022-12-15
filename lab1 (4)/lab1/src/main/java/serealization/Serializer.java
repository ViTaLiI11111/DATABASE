package serealization;

import hospital.*;

import java.util.List;

public interface Serializer {
    List<Doctor> listFromFile(String filename);

    Doctor fromFile(String fileName);

    void toFile(Doctor doctor, String fileName);

    void listToFile(List<Doctor> Doctor, String fileName);
}

