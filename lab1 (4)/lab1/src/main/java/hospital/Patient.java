package hospital;


import java.time.LocalDate;
import java.util.Objects;

/**
 * class "Patient" with fields: phoneNumber, medicalCardNumber, bloodType
 * @author User
 * @version 1.0
 */
public class Patient{
    public String firstname;
    public String lastname;
    public LocalDate dateOfBirth;
    public String phoneNumber;
    public int medicalCardNumber;
    public int bloodType;

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }

    public int getBloodType() {
        return bloodType;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", medicalCardNumber=" + medicalCardNumber +
                ", bloodType=" + bloodType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return medicalCardNumber == patient.medicalCardNumber && bloodType == patient.bloodType && Objects.equals(firstname, patient.firstname) && Objects.equals(lastname, patient.lastname) && Objects.equals(dateOfBirth, patient.dateOfBirth) && Objects.equals(phoneNumber, patient.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, dateOfBirth, phoneNumber, medicalCardNumber, bloodType);
    }

    /**
     *  Overridden function of obtaining a string representation of
     *  an instance of a class "Patient"
     *  @return returns the string representation
     */

    public static class Builder {
        private Patient patient;

        public Builder(){ patient = new Patient(); }

        /**
         * Setter type designation
         *
         * @param firstname - name
         * @return returns current object
         */
        public Builder setFirstname(String firstname){
            patient.firstname = firstname;
            return this;
        }

        /**
         * Setter type designation
         * @param lastname - surname
         * @return returns current object
         */
        public Builder setLastname(String lastname){
            patient.lastname = lastname;
            return this;
        }

        /**
         * Setter type designation
         * @param dateOfBirth - date of birth
         * @return returns current object
         */
        public Builder setDateOfBirth(LocalDate dateOfBirth){
            patient.dateOfBirth = dateOfBirth;
            return this;
        }
        /**
         * Setter type designation
         * @param medicalCardNumber - name
         * @return returns current object
         */
        public Builder setMedicalCardNumber(int medicalCardNumber){
            patient.medicalCardNumber = medicalCardNumber;
            return this;
        }

        /**
         * Setter type designation
         * @param bloodType - surname
         * @return returns current object
         */
        public Builder setBloodType(int bloodType){
            patient.bloodType = bloodType;
            return this;
        }

        /**
         * Setter type designation
         * @param phoneNumber - date of birth
         * @return returns current object
         */
        public Builder setPhoneNumber(String phoneNumber){
            patient.phoneNumber = phoneNumber;
            return this;
        }
        /**
         * Function of creating an object of class "Patient"
         * @return returns new object of class "Patient"
         */
        public Patient build(){
            return patient;
        }
    }

    public static void main(String args[]) {
    }
}