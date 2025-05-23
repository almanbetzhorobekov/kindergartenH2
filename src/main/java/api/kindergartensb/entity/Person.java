package api.kindergartensb.entity;


import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDate;


@MappedSuperclass
public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected LocalDate birthday;

    @ManyToOne
    protected Address address;


}
