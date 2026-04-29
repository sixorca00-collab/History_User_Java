package com.riwi.talent.model.entity;

/*
 * Los Records en Java 17+ combinados con JDBC moderno ofrecen ventajas claras
 * sobre los POJOs tradicionales de Java 8:
 *
 * 1. INMUTABILIDAD GARANTIZADA: Un record no permite modificar sus campos tras
 *    la construcción, lo que elimina efectos secundarios al mapear ResultSets.
 *    En un POJO se necesitaban setters que podían mutar el estado de forma
 *    involuntaria durante el recorrido del ResultSet.
 *
 * 2. MENOS CÓDIGO: El compilador genera automáticamente constructor canónico,
 *    getters, equals(), hashCode() y toString(). En Java 8, todo eso debía
 *    escribirse a mano o dependerse de Lombok.
 *
 * 3. LEGIBILIDAD DEL MAPEO: Al leer un ResultSet con try-with-resources y
 *    mapear cada fila a un Record, la intención del código es inmediata:
 *    new EmpleadoReporte(rs.getInt("id"), rs.getString("name"), ...)
 *    versus crear un POJO, llamar setId(), setName()... en pasos separados.
 *
 * 4. MANTENIMIENTO: Si la consulta SQL cambia y agrega o quita una columna,
 *    sólo se actualiza la firma del record. El compilador marca todos los
 *    sitios de construcción que deben adaptarse, eliminando errores silenciosos.
 */
public record DesempenoRecord(int idEmpleado, double promedio, String feedback) {
}
