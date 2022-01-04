package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_details_import_export")

public class DetailsImportExportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private String idImportExport;
    private String idCommodity;
    private String description;
    private Double quantity;
    private Integer total;

//    @ManyToOne
//    @JoinColumn(name = "id_commodity")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private CommodityEntity commodityEntity;
//    private List<CommodityEntity> commodityEntities;

}
