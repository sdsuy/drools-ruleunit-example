package com.example.drools.descuento;

import static org.junit.Assert.assertEquals;

import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.drools.model.Cliente;
import com.example.drools.rules.DescuentoRuleUnit;

public class DescuentoRuleTest {

    static final Logger LOG = LoggerFactory.getLogger(DescuentoRuleUnit.class);

    @Test
    public void testDescuentoClientes() {
        LOG.info("Creating RuleUnit");
        DescuentoRuleUnit descuentoUnit = new DescuentoRuleUnit();

        RuleUnitInstance<DescuentoRuleUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(descuentoUnit);

        try {
            LOG.info("Insert data");
            // Referencias directas a los objetos insertados
            Cliente juan = new Cliente("Juan", 20); // cumple la regla
            Cliente ana = new Cliente("Ana", 30); // no cumple la regla

            descuentoUnit.getClientes().add(juan);
            descuentoUnit.getClientes().add(ana);

            LOG.info("Rules should fire");
            instance.fire();

            // Verificamos los resultados
            assertEquals(10.0, juan.getDescuento(), 0.1);
            assertEquals(0.0, ana.getDescuento(), 0.1);
        } finally {
            instance.close();
        }

    }
}
