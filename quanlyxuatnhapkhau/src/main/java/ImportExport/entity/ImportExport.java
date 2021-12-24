package ImportExport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_import_export")
public class ImportExport {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    public UUID id;
    public String idCountry;
    public String idWarehouse;
    public Date date;
    public byte type;

    @ManyToMany
    private List<CountryEntity> countryEntities;

    @ManyToMany
    private List<WareHouseEntity> wareHouseEntities;

    @ManyToMany(mappedBy = "importExports")
    public List<Document> documents;

    @ManyToMany(mappedBy = "importExports")
    public List<DetailsImportExport> detailsImportExports;
}
