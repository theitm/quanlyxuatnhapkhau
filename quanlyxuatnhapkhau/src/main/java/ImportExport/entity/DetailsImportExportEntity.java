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
@Table(name = "tb_details_import_export")
public class DetailsImportExportEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_import_export")
    @Type( type = "uuid-char")
    private UUID idImportExport;

    @Column( name = "id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "total")
    private Integer total;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "importExportEntity_id",nullable = false)
//    private ImportExportEntity importExportEntity;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "commodityEntity_id",nullable = false)
//    private CommodityEntity commodityEntity;
}
