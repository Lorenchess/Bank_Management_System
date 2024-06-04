package com.chess4math.bank_management_system_bank_service.entities;

import com.chess4math.bank_management_system_bank_service.enums.BankCodes;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "bank_code")
    private BankCodes bankCode;

    @OneToMany(mappedBy = "bank_id", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Administrator> administrators;

    //defensive copy
    public List<Administrator> getAdministrators() {
        return new ArrayList<>(administrators);
    }

    public void addAdministratorAndSetBiReference(Administrator administrator) {
        if (administrator != null){
            administrators.add(administrator);
            administrator.setBank(this);
        }
    }
}
