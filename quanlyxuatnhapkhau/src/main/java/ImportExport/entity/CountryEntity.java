package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_country")
public class CountryEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private String country_name;
    private float tax;
    private float transport_fee;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<ImportExportEntity> importExportEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "countryEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<EmbargoEntity> embargoEntities= new ArrayList<>();
}