package kg.inai.socfond.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)(strategy = GenerationType.AUTO)
    Long id;

    String name;

    Long ateTypeCode;
}
