package comparators;

import hospital.Doctor;
import java.util.Comparator;

public class DoctorComparator implements Comparator<Doctor> {
    @Override
    public int compare(Doctor d1, Doctor d2){
        if (d1.getLastname().compareTo(d2.getLastname()) == 0) {
            return d1.getFirstname().compareTo(d2.getFirstname());
        }
        return d1.getLastname().compareTo(d2.getLastname());
    }
}
