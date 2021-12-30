package ImportExport.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_import_export")
public class ImportExportEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;

    @Column( name = "id_warehouse")
    @Type( type = "uuid-char")
    private UUID warehouse;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "type")
    private Byte type;

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


   /* @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DocumentEntity> documentEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "importExportEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<DetailsImportExportEntity> detailsImportExportEntities = new ArrayList<>();*/
}
