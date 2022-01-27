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
public class PlaceName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    PlaceType placeType;

    @ManyToOne(cascade = {CascadeType.ALL})
    Rayon rayon;

    @ManyToOne(cascade = {CascadeType.ALL})
    Oblast oblast;
}
