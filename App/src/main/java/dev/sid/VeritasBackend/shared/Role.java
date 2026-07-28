package dev.sid.VeritasBackend.shared;

import dev.sid.VeritasBackend.Entities.Employees;
import jakarta.persistence.OneToOne;

public enum Role {

    HR("HR"),
    PAYROLL_OFFICER("PAYROLL_OFFICER"),
    MANAGER("MANAGER"),
    EMPLOYEE("EMPLOYEE"),
    AUDITOR("AUDITOR"),
    SYSTEM_ADMIN("SYSTEM_ADMIN");

    private String role;

    @OneToOne(mappedBy = "role")
    private Employees employee;

    Role(String string) {
        this.role = string;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
