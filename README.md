# Drools Rule Unit Example

Este repositorio demuestra el uso de Drools Rule Units (modelo basado en clases Java, sin archivos `.drl`) utilizando el arquetipo oficial `kie-drools-exec-model-ruleunit-archetype`.

## Primer commit: proyecto generado desde el arquetipo

Se crea un proyecto base mediante:

```
mvn archetype:generate \
  -DarchetypeGroupId=org.kie \
  -DarchetypeArtifactId=kie-drools-exec-model-ruleunit-archetype \
  -DarchetypeVersion=8.44.0.Final
```

Esto genera un `MeasurementUnit`, que actúa como modelo y fuente de datos para la regla `FindColor`. La regla (escrita en DRL) selecciona mediciones con id `"color"` y agrega sus valores a un `Set` de control.

El test asociado (`RuleTest`) verifica que los datos se insertan correctamente, que las reglas se ejecutan y que los valores esperados se encuentran en el `controlSet`.

## Segundo commit: nuevo RuleUnit basado en Java

Se incorpora un nuevo `RuleUnit` llamado `DescuentoRuleUnit`, el cual define reglas puramente en Java usando el modelo de ejecución:

- Se define una clase `Cliente` con nombre, edad y porcentaje de descuento.
- La regla establece que si un cliente es menor a 25 años de edad, se le asigna un 10% de descuento.

```java
descuentoUnit.getClientes().add(juan);
descuentoUnit.getClientes().add(ana);
```

## Test incluido

El test `DescuentoRuleTest`:

1. Crea una instancia de la regla con dos clientes Juan y Ana de 20 y 30 años de edad respectivamente.
2. Ejecuta la unidad de reglas.
3. Verifica que a Juan se le asignó un 10% de descuento.

## Cómo ejecutar los tests

Desde la raíz del proyecto, simplemente:

```bash
mvn clean test
```

Esto compilará el proyecto, ejecutará ambos tests (`RuleTest` y `DescuentoRuleTest`) y mostrará la salida con las INFO extras de Logger.

---

Proyecto de ejmplo de un RMB en: https://github.com/sdsuy/drools-ruleunit-example
