package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Staj extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    Country country;

    @Column(columnDefinition = "TEXT")
    String vidDeyatelnosti;

    @Column(columnDefinition = "TEXT")
    String typePeriod;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateStartPeriod;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateEndPeriod;

    @Column(columnDefinition = "TEXT")
    String organisation;

    @Column(columnDefinition = "TEXT")
    String organisationAddress;

}
