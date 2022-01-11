package ImportExport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_country")
public class CountryEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "country_name")
    private String countryName;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "transport_fee")
    private Double transportFee;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "countryEntity"
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<EmbargoEntity> embargoEntities
            = new ArrayList<EmbargoEntity>();

}
