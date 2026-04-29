package com.riwi.talent.controller;

import com.riwi.talent.model.dao.EmpleadoDAOImpl;
import com.riwi.talent.model.entity.Empleado;

import java.util.List;
import java.util.Optional;

public class EmpleadoController {

    private final EmpleadoDAOImpl dao = new EmpleadoDAOImpl();

    public void registrarEmpleado(String name, int age, boolean isRemote, long salary) {
        Empleado nuevo = new Empleado(0, name, age, isRemote, salary);
        dao.insertar(nuevo);
    }

    public List<Empleado> obtenerTodos() {
        return dao.listar();
    }

    public Optional<Empleado> buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    public void actualizarEmpleado(int id, String name, int age, boolean isRemote, long salary) {
        Empleado actualizado = new Empleado(id, name, age, isRemote, salary);
        dao.actualizar(actualizado);
    }

    public void eliminarEmpleado(int id) {
        dao.eliminar(id);
    }

    public String generarReporteTexto() {
        List<Empleado> empleados = dao.generarReporte();

        if (empleados.isEmpty()) {
            return "No hay empleados registrados en la base de datos.";
        }

        StringBuilder sb = new StringBuilder();
        for (Empleado e : empleados) {
            String modalidad = e.isRemote() ? "Remoto" : "Presencial";
            String categoria = clasificarSalario(e.salaryByMonth());
            sb.append(String.format("""
                    ┌─────────────────────────────────────────────┐
                    │  ID        : %-32d│
                    │  Nombre    : %-32s│
                    │  Edad      : %-32d│
                    │  Modalidad : %-32s│
                    │  Salario   : $%-31d│
                    │  Categoría : %-32s│
                    └─────────────────────────────────────────────┘
                    """,
                    e.id(), e.name(), e.age(), modalidad, e.salaryByMonth(), categoria));
        }
        return sb.toString();
    }

    private String clasificarSalario(long salary) {
        if (salary <= 1000)      return "Junior Developer";
        if (salary <= 2500)      return "Mid Developer";
        if (salary <= 3000)      return "Senior Developer";
        if (salary <= 6000)      return "Architect Developer";
        return "Executive";
    }
}
