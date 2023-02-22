package com.coli.springsnippets.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tenants")
@ToString
public class Tenant {

    @Id
    private Integer id;

    @Getter
    @Setter
    private String name;

    private String language;

    private String multipharmaId;  // for invoicing external clients

    private String pharmacist; // Pharmacist name for Totalmed

    private String pharmacyPhone;

    private String street;

    private String city;

    private String postalcode;

    private String codeInvoicing;
}
