package peaksoft.ekzamtask3etap.ekzam_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import peaksoft.ekzamtask3etap.ekzam_task.enams.HouseType;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "houses_gen")
    @SequenceGenerator(name = "houses_gen",sequenceName = "houses_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private HouseType houseType;
    @NotNull
    private String address;
    @NotNull
    private int price;
    @NotNull
    private int room;
    @NotNull
    private String country;
    @NotNull
    private String description;
    @NotNull
    private String isBooked;


    @ManyToOne(cascade = {CascadeType.ALL})
    private Agency agency;

    @OneToOne(mappedBy = "house",cascade = {CascadeType.ALL})
    private Booking booking;
}
