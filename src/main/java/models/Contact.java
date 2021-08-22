package models;

import lombok.*;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Contact {
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    String description;


}
