package peaksoft.ekzamtask3etap.ekzam_task.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_gen")
    @SequenceGenerator(name = "booking_gen",sequenceName = "booking_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Customer customer;

    @OneToOne(cascade = {CascadeType.ALL})
    private House house;
}
