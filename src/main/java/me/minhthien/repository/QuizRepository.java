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
import me.minhthien.model.Quiz;

public class QuizRepository {
    
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
    
    public void createQuiz(Quiz quiz) {
        conn  = DBConfig.getConn();

        String CREATE_QUIZ_SQL = "INSERT INTO quiz(name, timeout, subject_id, create_date) VALUES(?, ?, ?, ?)";
        ResultSet rs = null;

        try (
            PreparedStatement CREATE_PS = conn.prepareStatement(CREATE_QUIZ_SQL, Statement.RETURN_GENERATED_KEYS)){

            CREATE_PS.setString(1, quiz.getName());
            CREATE_PS.setInt(2, quiz.getTimeout());
            CREATE_PS.setInt(3, quiz.getSubjectId());
            CREATE_PS.setDate(4, Date.valueOf(quiz.getCreateDate()));
            CREATE_PS.execute();

            rs = CREATE_PS.getGeneratedKeys();
            rs.next();
            quiz.setId(rs.getInt(1));
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
    }

    public List<Quiz> getAllQuiz() {
        conn  = DBConfig.getConn();

        String GET_QUIZ_SQL = "SELECT q.id, "
            + "q.name, "
            + "q.timeout, "
            + "s.id as subject_id, "
            + "q.create_date, "
            + "s.name as subject_name "
            + "FROM quiz q JOIN subject s ON s.id = q.subject_id";
        ResultSet rs = null;

        try (
            PreparedStatement ps = conn.prepareStatement(GET_QUIZ_SQL)){
            List<Quiz> quizs = new ArrayList<>();

            rs = ps.executeQuery();
            while(rs.next()) {
                Quiz quiz = new Quiz(
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDate(5).toLocalDate()
                );
                quiz.setSubjectName(rs.getString(6));
                quiz.setId(rs.getInt(1));

                quizs.add(quiz);
            }

            rs.close();
            return quizs;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public Quiz getQuiz(Integer id) {
        conn  = DBConfig.getConn();
    
        String GET_QUIZ_SQL = "SELECT q.id, "
            + "q.name, "
            + "q.timeout, "
            + "s.id as subject_id, "
            + "q.create_date, "
            + "s.name as subject_name "
            + "FROM quiz q JOIN subject s ON s.id = q.subject_id";
        ResultSet rs = null;

        try (
            PreparedStatement ps = conn.prepareStatement(GET_QUIZ_SQL)){
            rs = ps.executeQuery();
            if(rs.next()) {
                Quiz quiz = new Quiz(
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDate(5).toLocalDate()
                );
                quiz.setSubjectName(rs.getString(6));
                quiz.setId(rs.getInt(1));

                return quiz;
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public boolean deleteQuiz(Integer id) {
        conn  = DBConfig.getConn();
        String DELETE_QUIZ_SQL = "DELETE FROM quiz WHERE id = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(DELETE_QUIZ_SQL)){
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


    public boolean updateQuiz(Quiz quiz) {
        conn  = DBConfig.getConn();
        int rs = -1;
        String UPDATE_QUIZ_SQL = "UPDATE quiz SET name = ?, "
            + "timeout = ?, "
            + "subject_id = ? "
            + "WHERE id = ?";

        try (
            PreparedStatement ps = conn.prepareStatement(UPDATE_QUIZ_SQL)){
            ps.setString(1, quiz.getName());
            ps.setInt(2, quiz.getTimeout());
            ps.setInt(3, quiz.getSubjectId());

            ps.setInt(4, quiz.getId());
            rs = ps.executeUpdate();
        } catch (SQLException exc) {
            exc.printStackTrace();
            return false;
        } finally {
            closeConn(conn);
        }
        return rs >= 1;
    }
    
    public List<Quiz> getAllQuizBySubjectId(int subjectId) {
        conn  = DBConfig.getConn();
        
        String GET_QUIZ_SQL = "SELECT q.id, "
            + "q.name, "
            + "q.timeout, "
            + "s.id as subject_id, "
            + "q.create_date, "
            + "s.name as subject_name "
            + "FROM quiz q JOIN subject s ON s.id = q.subject_id WHERE q.subject_id = ?";
        ResultSet rs = null;
        
        try (
            PreparedStatement ps = conn.prepareStatement(GET_QUIZ_SQL)){
            ps.setInt(1, subjectId);
            
            List<Quiz> quizs = new ArrayList<>();
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Quiz quiz = new Quiz(
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getDate(5).toLocalDate()
                );
                quiz.setSubjectName(rs.getString(6));
                quiz.setId(rs.getInt(1));
                
                quizs.add(quiz);
            }
            
            rs.close();
            return quizs;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }
    /*
     *   Tools
     * */
    public boolean checkExistQuiz(String name) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_QUIZ_SQL = "SELECT id FROM quiz WHERE name = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_QUIZ_SQL)){
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

    public boolean checkExistQuiz_withId(int id) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_QUIZ_SQL = "SELECT id FROM quiz WHERE id = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_QUIZ_SQL)){
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
