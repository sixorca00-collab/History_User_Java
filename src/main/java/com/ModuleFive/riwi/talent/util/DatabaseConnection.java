package com.riwi.talent.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * GESTIÓN DE CONEXIONES: LEGACY VS MODERNA
 *
 * ── SINTAXIS LEGACY (Java 8 hacia atrás) ──────────────────────────────────
 * Antes de Java 7 no existía try-with-resources. El cierre de Connection,
 * PreparedStatement y ResultSet debía hacerse manualmente en un bloque finally,
 * lo que generaba código verboso y propenso a errores:
 *
 *   Connection conn = null;
 *   PreparedStatement ps = null;
 *   ResultSet rs = null;
 *   try {
 *       conn = DriverManager.getConnection(URL, USER, PASS);
 *       ps   = conn.prepareStatement("SELECT ...");
 *       rs   = ps.executeQuery();
 *       // procesar rs...
 *   } catch (SQLException e) {
 *       e.printStackTrace();
 *   } finally {
 *       if (rs   != null) try { rs.close();   } catch (SQLException ignored) {}
 *       if (ps   != null) try { ps.close();   } catch (SQLException ignored) {}
 *       if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
 *   }
 *
 * Problemas del enfoque legacy:
 *   • Si el desarrollador olvidaba un close(), la conexión quedaba abierta
 *     (Memory Leak / Connection Leak), agotando el pool de la BD.
 *   • El finally anidado triplicaba el tamaño del código.
 *   • Una excepción en el propio finally podía ocultar la excepción original.
 *
 * ── SINTAXIS MODERNA (Java 17/21 — try-with-resources) ────────────────────
 * Java 7 introdujo try-with-resources (ARM - Automatic Resource Management).
 * Cualquier objeto que implemente AutoCloseable se cierra AUTOMÁTICAMENTE al
 * salir del bloque try, tanto en caso de éxito como de excepción.
 *
 * PREVENCIÓN DE MEMORY LEAKS:
 *   • Connection, PreparedStatement y ResultSet implementan AutoCloseable.
 *   • El compilador inserta las llamadas a close() en el bytecode generado,
 *     garantizando que nunca queden recursos abiertos, sin importar qué
 *     excepción se lance dentro del bloque.
 *   • Al cerrar la Connection se devuelve el recurso al pool de la BD,
 *     evitando el agotamiento de conexiones disponibles en producción.
 */
public class DatabaseConnection {

    private static final String URL  = "jdbc:mysql://localhost:3306/talent_hub?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
