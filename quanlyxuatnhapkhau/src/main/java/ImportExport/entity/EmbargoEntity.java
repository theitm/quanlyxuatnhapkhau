package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_embargo")
public class EmbargoEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_type_of_commodity")
    @Type( type = "uuid-char")
    private UUID idTypeOfCommodity;

    @Column( name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;

    @Column(name = "description")
    private String description;

    @Column(name = "activate",columnDefinition = "tinyint")
    private int activate;

    @Column(name = "active")
    private Integer active;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional=false)
//    @JoinColumn(name = "TypeOfCommodityEntity_id",nullable = false)
//    private TypeOfCommodityEntity typeOfCommodityEntity;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "countryEntity_id",nullable = false)
//    private CountryEntity countryEntity;
}
