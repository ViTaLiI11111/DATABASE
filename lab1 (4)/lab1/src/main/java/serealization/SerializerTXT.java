package serealization;
import hospital.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SerializerTXT implements Serializer{
    private String toString(Doctor d) {
        return
                "Firstname~" + d.getFirstname() + "~" +
                        "Lastname~" + d.getLastname() + "~" +
                        "Position~" + d.getPosition() + "~" +
                        "Salary~" + d.getSalary() + "~" +
                        "Date of birth~" + d.getDateOfBirth() + "~" +
                        "Phone number~" + d.getPhoneNumber() + "~" +
                        "Cabinet~" + d.getCabinetNumber();
    }
    private String toString(List<Doctor> doctors) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<doctors.size(); i++) {
            res.append(toString(doctors.get(i)));
            if (i+1 < doctors.size()) {
                res.append(";");
            }
        }
        return res.toString();
    }
    private Doctor fromString(String s){
        String [] obj = s.split("~");
        Doctor res = new Doctor();
        res.setFirstname(obj[1]);
        res.setLastname(obj[3]);
        res.setPosition(obj[5]);
        res.setSalary(Integer.parseInt(obj[7]));
        res.setDateOfBirth(LocalDate.parse(obj[9]));
        res.setPhoneNumber(obj[11]);
        res.setCabinetNumber(Integer.parseInt(obj[13]));
        return res;
    }

    private  List<Doctor> fromStringList(String s){
        String [] obj = s.split(";");
        List<Doctor> res = new ArrayList<>();
        for(String item:obj){
            res.add(fromString(item));
        }
        return res;
    }

    @Override
    public List<Doctor> listFromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromStringList(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Doctor fromFile(String fileName) {
        try (
                FileReader fw = new FileReader(new File(fileName));
                BufferedReader bw = new BufferedReader(fw)) {
            return fromString(bw.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toFile(Doctor doctor, String fileName) {
        try (
                FileWriter fw = new FileWriter(new File(fileName));
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(toString(doctor));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void listToFile(List<Doctor> doctors, String fileName) {
        try(
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(toString(doctors));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        Doctor doctor = new Doctor();
        doctor.setFirstname("Name");
        doctor.setLastname("Surname");
        doctor.setPosition("Nurse");
        doctor.setCabinetNumber(1);
        doctor.setDateOfBirth(LocalDate.of(2001, 1, 1));
        doctor.setPhoneNumber("0991188726");
        doctor.setSalary(9000);
        Serializer serializer = new SerializerTXT();
        serializer.toFile(doctor, "doctorTXT");


        List<Doctor> doctors = new ArrayList<>();
        doctors.add(doctor);
        doctor = new Doctor();
        doctor.setFirstname("Vitaliy");
        doctor.setLastname("Levytskiy");
        doctor.setPosition("Doctor");
        doctor.setCabinetNumber(11);
        doctor.setDateOfBirth(LocalDate.of(2002, 10, 11));
        doctor.setPhoneNumber("0661188726");
        doctor.setSalary(7000);
        doctors.add(doctor);
        serializer.listToFile(doctors, "doctorsTXT");

        doctor = serializer.fromFile("doctorTXT");
        System.out.println(doctor);
        doctors = serializer.listFromFile("doctorsTXT");
        System.out.println(doctors);
    }
}