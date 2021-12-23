package ImportExport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_warehouse")

public class WareHouseEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private String warehouse_name;
    private String description;
    private double capacity;

    @ManyToMany(mappedBy = "wareHouseEntities")
    public List<ImportExport> importExports;

    @ManyToMany(mappedBy = "wareHouseEntities")
    public List<WareHouseCommodityEntity> wareHouseCommodityEntities;
}
