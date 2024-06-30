package peaksoft.ekzamtask3etap.ekzam_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import peaksoft.ekzamtask3etap.ekzam_task.enams.Gender;
import peaksoft.ekzamtask3etap.ekzam_task.validations.ValidPhoneNumber;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen",sequenceName = "customer_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
    @NotNull
    private Gender gender;
    @NotNull
    @ValidPhoneNumber
    private String phoneNumber;
    @NotNull
    private LocalDate dateOfBirth;

    @ManyToMany(mappedBy = "customers",cascade = {CascadeType.ALL})
    private List<Agency> agencies;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
