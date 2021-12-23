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
@Table(name = "tb_type_of_commodity")
public class TypeOfCommodity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    public UUID id;
    public String idTaxBracket;
    public String typeOfCommodityName;
    public String description;

    @ManyToMany(mappedBy = "typeOfCommodities")
    public List<Commodity> commodities;

    @ManyToMany(mappedBy = "typeOfCommodities")
    public List<EmbargoEntity> embargoEntities;

    @ManyToMany
    private List<TaxBracketEntity> taxBracketEntities;
}