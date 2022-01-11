package ImportExport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_document")

public class DocumentEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "id_import_export")
    @Type( type = "uuid-char")
    private UUID idImportExport;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "id_import_export",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private ImportExportEntity importExportEntity;

}

