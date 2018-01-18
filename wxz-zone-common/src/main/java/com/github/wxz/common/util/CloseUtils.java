package com.github.wxz.common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * type: class
 *
 * @author xianzhi.wang
 * @see
 * @since JDK 1.8
 */
public class CloseUtils {
    public CloseUtils() {
    }

    public static void close(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception var2) {

        }

    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception var2) {

        }

    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception var2) {

        }

    }

    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception var2) {

        }

    }

    public static void close(Object object) {
        try {
            if (object != null && object instanceof AutoCloseable) {
                ((AutoCloseable) object).close();
            }
        } catch (Exception var2) {

        }

    }
}
