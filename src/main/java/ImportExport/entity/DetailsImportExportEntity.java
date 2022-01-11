package ImportExport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
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
    @Column(name = "id_import_export")
    @Type( type = "uuid-char")
    private UUID idImportExport;
    @Column(name = "id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;
    private String description;
    private Double quantity;
    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private CommodityEntity commodityEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_import_export",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private ImportExportEntity importExportEntity;


}
