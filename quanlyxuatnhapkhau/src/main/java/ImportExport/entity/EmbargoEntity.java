package ImportExport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_embargo")
public class EmbargoEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private String id_type_of_commodity;
    private String id_country;
    private String description;
    @Column(name = "activate",columnDefinition = "tinyint")
    private int activate;
    private Integer active;

    @ManyToMany
    private List<TypeOfCommodity> typeOfCommodities;

    @ManyToMany
    private List<CountryEntity> countryEntities;
}
