package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public UUID id;
    public String idCountry;
    public String warehouse;
    public Date date;
    public Byte type;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn(name = "countryEntity_id",nullable = false)
    private CountryEntity countryEntity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn(name = "wareHouseEntity_id",nullable = false)
    private WareHouseEntity wareHouseEntity;


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DocumentEntity> documentEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<DetailsImportExportEntity> detailsImportExportEntities = new ArrayList<>();
}
