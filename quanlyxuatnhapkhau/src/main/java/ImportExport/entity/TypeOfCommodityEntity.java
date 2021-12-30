package ImportExport.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_type_of_commodity")
public class TypeOfCommodityEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_tax_bracket")
    @Type( type = "uuid-char")
    private UUID idTaxBracket;

    @Column(name = "type_of_commodity_name")
    private String typeOfCommodityName;

    @Column(name = "description")
    private String description;

    /*@EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "typeOfCommodityEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<CommodityEntity> commodityEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "typeOfCommodityEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<EmbargoEntity> embargoEntities = new ArrayList<>();


    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional = false)
    @JoinColumn(name = "taxBracketEntity",nullable = false)
    private TaxBracketEntity taxBracketEntity;*/
}