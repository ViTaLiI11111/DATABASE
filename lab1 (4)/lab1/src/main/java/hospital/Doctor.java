package hospital;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Doctor implements Comparable<Doctor> {
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "First name must consists only from letter and first letter must be UpperCase")
    public String firstname;
    @Pattern(regexp = "[A-Z][a-z]{1,32}", message = "Last name must consists only from letter and first letter must be UpperCase")
    public String lastname;
    @PastOrPresent(message = "Date must be in the past or in the present")
    public LocalDate dateOfBirth;
    public String phoneNumber;
    public int cabinetNumber;
    public int salary;
    public String position;
    public List<Patient> patients = new ArrayList<>();

    @Override
    public int compareTo(Doctor d) {
        if (lastname.compareTo(d.lastname) == 0) {
            return firstname.compareTo(d.firstname);
        }
        return lastname.compareTo(d.lastname);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cabinetNumber=" + cabinetNumber +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                ", patients=" + patients +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor doctor)) return false;
        return cabinetNumber == doctor.cabinetNumber && salary == doctor.salary && Objects.equals(firstname, doctor.firstname) && Objects.equals(lastname, doctor.lastname) && Objects.equals(dateOfBirth, doctor.dateOfBirth) && Objects.equals(phoneNumber, doctor.phoneNumber) && Objects.equals(position, doctor.position) && Objects.equals(patients, doctor.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, dateOfBirth, phoneNumber, cabinetNumber, salary, position, patients);
    }

    public static class Builder {
        private Doctor doctor;

        public Builder(){ doctor = new Doctor(); }
        /**
         * Setter type designation
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            doctor.firstname = firstname;
            return this;
        }

        /**
         * Setter type designation
         * @param lastname - surname
         * @return returns current object
         */
        public Builder setLastname(String lastname){
            doctor.lastname = lastname;
            return this;
        }

        /**
         * Setter type designation
         * @param dateOfBirth - date of birth
         * @return returns current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            doctor.dateOfBirth = dateOfBirth;
            return this;
        }
        /**
         * Setter type designation
         * @param phoneNumber - phone number
         * @return returns current object
         */
        public Builder setPhoneNumber(String phoneNumber){
            doctor.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Setter type designation
         * @param cabinetNumber - number of cabinet
         * @return returns current object
         */
        public Builder setCabinetNumber(int cabinetNumber){
            doctor.cabinetNumber = cabinetNumber;
            return this;
        }

        /**
         * Setter type designation
         * @param salary - salary
         * @return returns current object
         */
        public Builder setSalary(int salary){
            doctor.salary = salary;
            return this;
        }
        /**
         * Setter type designation
         * @param patients - list of patients
         * @return returns current object
         */
        public Builder setPatients(List<Patient> patients){
            doctor.patients.addAll(patients);
            return this;
        }

        /**
         * Setter type designation
         * @param position - position
         * @return returns current object
         */
        public Builder setPosition(String position){
            doctor.position = position;
            return this;
        }

        /**
         * Function of creating an object of class "Person"
         * @return returns new object of class "Person"
         */
        public Doctor build(){
            validate(doctor);
            return doctor;
        }
    }

    private static void validate(Doctor doctor) throws IllegalArgumentException {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


        Set<ConstraintViolation<Doctor>> check = validator.validate(doctor);

        StringBuilder sb = new StringBuilder();

        for(ConstraintViolation<Doctor> element : check){
            sb.append("Error value "+element.getInvalidValue() + " because " + element.getMessage());
            sb.append("\n");
        }

        if(sb.length() > 0){
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static void main(String args[]) {
        try{
            Doctor doctor = new Doctor.Builder()
                    .setFirstname("Helen")
                    .setLastname("lev6fosj")
                    .setDateOfBirth(LocalDate.of(2003, 1, 9))
                    .build();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}

