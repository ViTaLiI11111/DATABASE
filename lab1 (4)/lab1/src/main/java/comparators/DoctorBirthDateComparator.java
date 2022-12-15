package comparators;


import hospital.Doctor;

import java.util.Comparator;

public class DoctorBirthDateComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor d1, Doctor d2){
        return d1.getDateOfBirth().compareTo(d2.getDateOfBirth());
    }
}
