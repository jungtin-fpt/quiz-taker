package me.minhthien.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import me.minhthien.config.DBConfig;
import me.minhthien.model.Subject;

public class SubjectRepository {
    
    private Connection conn = null;
    
    private void closeConn(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }
    
    public void createSubject(Subject subject) {
        conn  = DBConfig.getConn();

        String CREATE_SUBJECT_SQL = "INSERT INTO subject(name, create_date) VALUES(?, ?)";
        ResultSet rs = null;

        try (
            PreparedStatement CREATE_PS = conn.prepareStatement(CREATE_SUBJECT_SQL, Statement.RETURN_GENERATED_KEYS)){

            CREATE_PS.setString(1, subject.getName());
            CREATE_PS.setDate(2, Date.valueOf(subject.getCreateDate()));
            CREATE_PS.execute();

            rs = CREATE_PS.getGeneratedKeys();
            rs.next();
            subject.setId(rs.getInt(1));
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
    }

    public List<Subject> getAllSubject() {
        conn  = DBConfig.getConn();

        String GET_SUBJECT_SQL = "SELECT id, name, create_date FROM subject";
        ResultSet rs = null;

        try (
            PreparedStatement ps = conn.prepareStatement(GET_SUBJECT_SQL)){
            List<Subject> subjects = new ArrayList<>();

            rs = ps.executeQuery();
            while(rs.next()) {
                Subject subject = new Subject(
                    rs.getString(2),
                    rs.getDate(3).toLocalDate()
                );
                subject.setId(rs.getInt(1));

                subjects.add(subject);
            }

            rs.close();
            return subjects;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public Subject getSubject(Integer id) {
        conn  = DBConfig.getConn();

        String GET_SUBJECT_SQL = "SELECT id, name, create_date FROM subject a WHERE a.id = ?";
        ResultSet rs = null;

        try (
            PreparedStatement ps = conn.prepareStatement(GET_SUBJECT_SQL)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Subject subject = new Subject(
                    rs.getString(2),
                    rs.getDate(3).toLocalDate()
                );
                subject.setId(rs.getInt(1));

                return subject;
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public boolean deleteSubject(Integer id) {
        conn  = DBConfig.getConn();
        String DELETE_SUBJECT_SQL = "DELETE FROM subject WHERE id = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(DELETE_SUBJECT_SQL)){
            ps.setInt(1, id);
            if(ps.executeUpdate() >= 1)
                return true;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return false;
    }


    public boolean updateSubject(Subject subject) {
        conn  = DBConfig.getConn();
        int rs = -1;
        String UPDATE_SUBJECT_SQL = "UPDATE subject SET name = ? "
            + "WHERE id = ?";

        try (
            PreparedStatement ps = conn.prepareStatement(UPDATE_SUBJECT_SQL)){
            ps.setString(1, subject.getName());

            ps.setInt(2, subject.getId());
            rs = ps.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
            return false;
        } finally {
            closeConn(conn);
        }
        return rs >= 1;
    }

    /*
     *   Tools
     * */
    public boolean checkExistSubject(String name) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_SUBJECT_SQL = "SELECT id FROM subject WHERE name = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_SUBJECT_SQL)){
            // check exist user
            CHECK_PS.setString(1, name);
            rs = CHECK_PS.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }

        return false;
    }

    public boolean checkExistSubject_withId(int id) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_SUBJECT_SQL = "SELECT id FROM subject WHERE id = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_SUBJECT_SQL)){
            // check exist user
            CHECK_PS.setInt(1, id);
            rs = CHECK_PS.executeQuery();
            if(rs.next())
                return true;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }

        return false;
    }
    
}
