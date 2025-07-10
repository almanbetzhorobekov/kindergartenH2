package api.kindergartensb.praesentation;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();

        Child childEmma= new Child(
                "Emma",          // firstName
                "Müller",        // lastName
                5,               // age
                "Female",        // gender
                "Bergstraße 12", // address
                "German",        // nationality
                "German",        // language
                false,           // hasAllergies
                "Bären-Gruppe",  // groupName
                "Teddy Bear"     // favoriteToy

        );
  

        System.out.println("Child created: " + childEmma.toString());
    }
}
