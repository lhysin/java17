package io.lhysin.java17.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Customer {
    @Id
    @Column
    private String custNo;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public static class CustomerBuilder {
        public CustomerBuilder withDefaultValue() {
            this.firstName = "DEFAULT_FIRST_NAME";
            return this;
        }
    }
}
