package com.example.drools.rules;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

import com.example.drools.model.Cliente;

public class DescuentoRuleUnit implements RuleUnitData {
    private final DataStore<Cliente> clientes;

    public DescuentoRuleUnit() {
        this.clientes = DataSource.createStore();
    }

    public DataStore<Cliente> getClientes() {
        return clientes;
    }
}
