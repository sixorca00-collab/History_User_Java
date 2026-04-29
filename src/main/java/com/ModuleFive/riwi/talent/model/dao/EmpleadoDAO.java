package com.riwi.talent.model.dao;

import com.riwi.talent.model.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoDAO {
    void insertar(Empleado empleado);
    List<Empleado> listar();
    Optional<Empleado> buscarPorId(int id);
    void actualizar(Empleado empleado);
    void eliminar(int id);
}
