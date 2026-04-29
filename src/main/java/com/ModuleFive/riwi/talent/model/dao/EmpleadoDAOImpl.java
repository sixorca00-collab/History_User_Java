package com.riwi.talent.model.dao;

import com.riwi.talent.model.entity.Empleado;
import com.riwi.talent.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    /*
     * SEGURIDAD — PreparedStatement vs Statement:
     * Todas las consultas usan PreparedStatement con parámetros posicionales (?).
     * Esto previene la inyección SQL porque el driver separa el código SQL de los
     * datos del usuario: los valores se envían al motor de BD como literales
     * tipados, no como texto que el parser SQL vaya a interpretar.
     * Con un Statement plano, un atacante podría introducir:
     *   id = "1 OR 1=1 --"
     * y obtener todos los registros. Con PreparedStatement eso no es posible
     * porque el valor se trata como dato, no como instrucción.
     */

    @Override
    public void insertar(Empleado empleado) {
        String sql = "INSERT INTO empleados (name, age, is_remote, salary_by_month) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empleado.name());
            ps.setInt(2, empleado.age());
            ps.setBoolean(3, empleado.isRemote());
            ps.setLong(4, empleado.salaryByMonth());
            ps.executeUpdate();
            System.out.println("Empleado insertado: " + empleado.name());

        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> listar() {
        String sql = "SELECT id, name, age, is_remote, salary_by_month FROM empleados";
        List<Empleado> lista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(mapearEmpleado(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Optional<Empleado> buscarPorId(int id) {
        String sql = "SELECT id, name, age, is_remote, salary_by_month FROM empleados WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearEmpleado(rs));
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar empleado: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void actualizar(Empleado empleado) {
        String sql = "UPDATE empleados SET name = ?, age = ?, is_remote = ?, salary_by_month = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, empleado.name());
            ps.setInt(2, empleado.age());
            ps.setBoolean(3, empleado.isRemote());
            ps.setLong(4, empleado.salaryByMonth());
            ps.setInt(5, empleado.id());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Empleado actualizado: " + empleado.name());
            } else {
                System.out.println("No se encontró empleado con id " + empleado.id());
            }

        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Empleado eliminado con id: " + id);
            } else {
                System.out.println("No se encontró empleado con id " + id);
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    public List<Empleado> generarReporte() {
        String sql = """
                SELECT id,
                       name,
                       age,
                       is_remote,
                       salary_by_month
                FROM empleados
                ORDER BY salary_by_month DESC
                """;
        List<Empleado> reporte = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                reporte.add(mapearEmpleado(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
        return reporte;
    }

    private Empleado mapearEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getBoolean("is_remote"),
                rs.getLong("salary_by_month")
        );
    }
}
