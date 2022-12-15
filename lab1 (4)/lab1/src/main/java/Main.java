import hospital.*;
import service.*;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient.Builder()
                .setFirstname("Vitaly")
                .setLastname("Levytsky")
                .setDateOfBirth(LocalDate.of(1997, 5, 18))
                .setBloodType(-1)
                .setMedicalCardNumber(11)
                .setPhoneNumber("0992766084").build();
        List<Patient> patientList = List.of(patient1);
        Doctor doctor = new Doctor.Builder()
                .setFirstname("Melice")
                .setLastname("Moreau")
                .setDateOfBirth(LocalDate.of(2001, 1, 14))
                .setPatients(patientList)
                .setPosition("Ophthalmologist")
                .setPhoneNumber("0667833082")
                .setCabinetNumber(11)
                .setSalary(25000).build();
        Doctor doctor1 = new Doctor.Builder()
                .setFirstname("Katherine")
                .setLastname("Clash")
                .setDateOfBirth(LocalDate.of(1995, 3, 11))
                .setPatients(patientList)
                .setPosition("Surgeon")
                .setPhoneNumber("0997833082")
                .setCabinetNumber(13)
                .setSalary(29000).build();
        Doctor doctor2 = new Doctor.Builder()
                .setFirstname("Alice")
                .setLastname("Aln")
                .setDateOfBirth(LocalDate.of(1999, 1, 1))
                .setPatients(patientList)
                .setPosition("Nurse")
                .setPhoneNumber("0667833082")
                .setCabinetNumber(1)
                .setSalary(21000).build();
        Doctor doctor3 = new Doctor.Builder()
                .setFirstname("Maks")
                .setLastname("White")
                .setDateOfBirth(LocalDate.of(2002, 2, 4))
                .setPatients(patientList)
                .setPosition("Ophthalmologist")
                .setPhoneNumber("0667833082")
                .setCabinetNumber(10)
                .setSalary(23000).build();

        List<Doctor> doctorList = List.of(doctor, doctor1, doctor2,doctor3);

        Hospital hospital = new Hospital.Builder()
                .setAddress("Holovna 121")
                .setNumber(1)
                .setDoctors(doctorList).build();
        HospitalService hospitalService = new HospitalService(hospital);

        System.out.println("Doctors sorted by full name:");
        System.out.println(hospitalService.sortByFirstnameLastname());

        System.out.println("\nDoctors sorted by full name (Stream):");
        System.out.println(hospitalService.sortByFirstnameLastnameStream());

        System.out.println("\nDoctors sorted by date of birth: ");
        System.out.println(hospitalService.sortByDateOfBirth());

        System.out.println("\nDoctors sorted by date of birth (Stream): ");
        System.out.println(hospitalService.sortByDateOfBirthStream());

        System.out.println("\nDoctors filtered by position (Ophthalmologist): ");
        System.out.println(hospitalService.filterPosition());

        System.out.println("\nDoctors filtered by position (Ophthalmologist) (Stream): ");
        System.out.println(hospitalService.filterPositionStream());

        System.out.println("\nDoctors filtered by date (Who was born after 2000): ");
        System.out.println(hospitalService.filterDate());

        System.out.println("\nDoctors filtered by date (Who was born after 2000) (Stream): ");
        System.out.println(hospitalService.filterDateStream());



    }

}
