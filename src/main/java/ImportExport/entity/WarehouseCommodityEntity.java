package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_warehouse_commodity")

public class WarehouseCommodityEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name="id_warehouse")
    @Type( type = "uuid-char")
    private UUID idWarehouse;
    @Column(name="id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;
    @Column(name = "inventory_number")
    private double inventoryNumber;
    @ManyToOne
    @JoinColumn(name = "id_commodity",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CommodityEntity commodityEntity;
    @ManyToOne
    @JoinColumn(name = "id_warehouse",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private WarehouseEntity warehouseEntity;
}
