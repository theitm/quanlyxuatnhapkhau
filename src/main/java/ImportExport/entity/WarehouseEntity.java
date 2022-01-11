package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_warehouse")

public class WarehouseEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "warehouse_name")
    private String warehouseName;
    private String description;
    private double capacity;
    @OneToMany(mappedBy = "warehouseEntity",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<WarehouseCommodityEntity> warehouseCommodityEntities
            =new ArrayList<WarehouseCommodityEntity>();
    @OneToMany(mappedBy = "warehouseEntity",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ImportExportEntity> importExportEntities
            =new ArrayList<ImportExportEntity>();

}