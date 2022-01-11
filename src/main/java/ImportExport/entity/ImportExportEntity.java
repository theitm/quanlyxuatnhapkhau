package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

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
    private WarehouseEntity warehouseEntity;
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<DocumentEntity> documentEntities
            = new ArrayList<DocumentEntity>();
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<DetailsImportExportEntity> detailsImportExportEntities
            =new ArrayList<DetailsImportExportEntity>();

}