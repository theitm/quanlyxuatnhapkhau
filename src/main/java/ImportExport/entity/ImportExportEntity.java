package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_import_export")

public class ImportExportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;
    @Column(name = "id_warehouse")
    @Type( type = "uuid-char")
    private UUID idWarehouse;
    private Date date;
    private int type;
    @ManyToOne
    @JoinColumn(name = "id_country",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CountryEntity countryEntity;
    @ManyToOne
    @JoinColumn(name = "id_warehouse",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private WarehouseEntity warehouse;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_import_export", referencedColumnName = "id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DocumentEntity> documents
            = new ArrayList<DocumentEntity>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_import_export", referencedColumnName = "id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DetailsImportExportEntity> detailsImportExports
            =new ArrayList<DetailsImportExportEntity>();

}