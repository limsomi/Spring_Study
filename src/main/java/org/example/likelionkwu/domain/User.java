package org.example.likelionkwu.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name="User")
public class User {

    @Id
    String UserName;
}
