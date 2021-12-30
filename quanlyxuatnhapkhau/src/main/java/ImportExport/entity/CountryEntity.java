package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_country")
public class CountryEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "tax")
    private float tax;

    @Column(name = "transport_fee")
    private float transportFee;

   /* @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<ImportExportEntity> importExportEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "countryEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<EmbargoEntity> embargoEntities= new ArrayList<>();*/
}
