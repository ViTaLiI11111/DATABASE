package service;

import hospital.Doctor;
import hospital.Hospital;
import comparators.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalService {
    private Hospital hospital;

    public HospitalService(Hospital hosp) {
        hospital = hosp;
    }

    public List<Doctor> sortByFirstnameLastname() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.addAll(hospital.getDoctors());
        Collections.sort(doctors);
        doctors.sort(new DoctorComparator());
        return doctors;
    }

    public List<Doctor> sortByFirstnameLastnameStream() {
        return hospital.getDoctors().stream().sorted(new DoctorComparator()).collect(Collectors.toList());
    }

    public List<Doctor>sortByDateOfBirth(){
        List<Doctor> doctors = new ArrayList<>();
        doctors.addAll(hospital.getDoctors());
        Collections.sort(doctors);
        doctors.sort(new DoctorBirthDateComparator());
        return doctors;
    }

    public List<Doctor> sortByDateOfBirthStream(){
        return hospital.getDoctors().stream().sorted(new DoctorBirthDateComparator()).collect(Collectors.toList());
    }

    public List<Doctor> filterPosition(){
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getPosition() == "Ophthalmologist") {
                doctors.add(doctor);
            }
        }
        return doctors;
    }
    public List<Doctor> filterPositionStream(){
        return hospital.getDoctors().stream().filter(position -> position.getPosition().contains("Ophthalmologist")).collect(Collectors.toList());
    }

    public List<Doctor> filterDate(){
        List<Doctor> doctors = new ArrayList<>();
        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getDateOfBirth().getYear() > 2000) {
                doctors.add(doctor);
            }
        }
        return doctors;
    }
    public List<Doctor> filterDateStream(){
        return hospital.getDoctors().stream().filter(birthDate -> birthDate.getDateOfBirth().isAfter(LocalDate.of(1999, Month.DECEMBER, 31))).collect(Collectors.toList());
    }
}