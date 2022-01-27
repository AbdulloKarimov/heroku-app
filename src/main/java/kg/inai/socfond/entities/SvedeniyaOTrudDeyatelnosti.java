package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SvedeniyaOTrudDeyatelnosti extends Audit<String> {

    @Id
    @GeneratedValue
    Long id;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TypeUchastnik typeUchastnik;

    @Nullable
    Boolean priznakOsushestvRaboty;

    @Nullable
    @ManyToOne(cascade = {CascadeType.ALL})
    TrudovayaDeyatelnost trudovayaDeyatelnost;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate workStartDate;

    @Nullable
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate workEndDate;



}
