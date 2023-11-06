import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    // Add other fields as needed

    // Getters and setters
}
