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
@Table(name = "tb_document")
public class DocumentEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_import_export")
    @Type( type = "uuid-char")
    private UUID idImportExport;

    @Column(name = "image_url")
    private String imageUrl;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional=false)
//    @JoinColumn(name = "importExportEntity_id",nullable = false)
//    private ImportExportEntity importExportEntity;
}