package noobchain.medical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class MedicalRecord {

    private String recordId;
    private String patientName;
    private String diagnosis;
    private Date date;
    private String description;

}

