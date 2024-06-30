package peaksoft.ekzamtask3etap.ekzam_task.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import peaksoft.ekzamtask3etap.ekzam_task.validations.ValidPhoneNumber;

import java.util.List;

@Entity
@Table(name = "agencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen",sequenceName = "agency_seq",allocationSize = 1)
    private Long id;
    @javax.validation.constraints.NotNull
    private String name;
    @NotNull
    private String country;
    @NotNull
    @ValidPhoneNumber
    private String phoneNumber;
    @NotNull
    private String email;
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<House> houses;

    @ManyToMany
    private List<Customer>customers;

    public Agency(String name, String country, String phoneNumber, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
