package ImportExport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_embargo")

public class EmbargoEntity  {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "id_type_of_commodity")
    @Type( type = "uuid-char")
    private UUID idTypeOfCommodity;
    @Column(name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;
    private String description;
    private int activate;
    private Integer active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private CountryEntity countryEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_of_commodity",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private TypeOfCommodityEntity typeOfCommodityEntity;

}