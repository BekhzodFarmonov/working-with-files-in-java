package uz.resourse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Data
public class User {
    private String id;
    private  String Fullname;
    private   UserType userType;
    private  String Password;
    
    
}
