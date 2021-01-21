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
import me.minhthien.model.Question;

public class QuestionRepository {
    
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
    
    public void createQuestion(Question question) {
        conn  = DBConfig.getConn();

        String CREATE_QUESTION_SQL = "INSERT INTO question(title, "
            + "answer_1, "
            + "answer_2, "
            + "answer_3, "
            + "answer_4, "
            + "correct_answer, "
            + "status, "
            + "quiz_id, "
            + "create_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ResultSet rs = null;

        try (
            PreparedStatement CREATE_PS = conn.prepareStatement(CREATE_QUESTION_SQL, Statement.RETURN_GENERATED_KEYS)){

            CREATE_PS.setString(1, question.getTitle());
            CREATE_PS.setString(2, question.getAnswer1());
            CREATE_PS.setString(3, question.getAnswer2());
            CREATE_PS.setString(4, question.getAnswer3());
            CREATE_PS.setString(5, question.getAnswer4());
            CREATE_PS.setInt(6, question.getCorrectAnswer());
            CREATE_PS.setBoolean(7, question.isStatus());
            CREATE_PS.setInt(8, question.getQuizId());
            CREATE_PS.setDate(9, Date.valueOf(question.getCreateDate()));
            CREATE_PS.execute();

            rs = CREATE_PS.getGeneratedKeys();
            rs.next();
            question.setId(rs.getInt(1));
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
    }

    public List<Question> getAllQuestionByQuizId(int quizId) {
        conn  = DBConfig.getConn();

        String GET_QUESTION_SQL = "SELECT id, title, answer_1, answer_2, answer_3, answer_4, "
            + "correct_answer, quiz_id, status, create_date FROM question WHERE quiz_id = ? AND status = 1";
        ResultSet rs = null;

        try (
            PreparedStatement ps = conn.prepareStatement(GET_QUESTION_SQL)){
            ps.setInt(1, quizId);
    
            List<Question> questions = new ArrayList<>();
            rs = ps.executeQuery();
            while(rs.next()) {
                Question question = new Question(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getBoolean(9),
                    rs.getDate(10).toLocalDate()
                );
                question.setId(rs.getInt(1));

                questions.add(question);
            }

            rs.close();
            return questions;
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public Question getQuestion(Integer id) {
        conn  = DBConfig.getConn();

        ResultSet rs = null;
        String GET_QUESTION_SQL = "SELECT id, title, answer_1, answer_2, answer_3, answer_4, "
            + "correct_answer, quiz_id, status, create_date FROM question WHERE id = ? AND status = 1";

        try (
            PreparedStatement ps = conn.prepareStatement(GET_QUESTION_SQL)){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Question question = new Question(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getInt(8),
                    rs.getBoolean(9),
                    rs.getDate(10).toLocalDate()
                );
                question.setId(rs.getInt(1));

                return question;
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return null;
    }

    public boolean deleteQuestion(Integer id) {
        conn  = DBConfig.getConn();
        String DELETE_QUESTION_SQL = "UPDATE question SET status = 0 "
            + "WHERE id = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(DELETE_QUESTION_SQL)){
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


    public boolean updateQuestion(Question question) {
        conn  = DBConfig.getConn();
        int rs = -1;
        String UPDATE_QUESTION_SQL = "UPDATE question SET title = ?, "
            + "answer_1 = ?, "
            + "answer_2 = ?, "
            + "answer_3 = ?, "
            + "answer_4 = ?, "
            + "correct_answer = ?, "
            + "WHERE id = ?";

        try (
            PreparedStatement ps = conn.prepareStatement(UPDATE_QUESTION_SQL)){
            ps.setString(1, question.getTitle());
            ps.setString(1, question.getAnswer1());
            ps.setString(1, question.getAnswer2());
            ps.setString(1, question.getAnswer3());
            ps.setString(1, question.getAnswer4());
            ps.setInt(1, question.getCorrectAnswer());

            ps.setInt(2, question.getId());
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
    public boolean checkExistQuestion(String name) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_QUESTION_SQL = "SELECT id FROM question WHERE name = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_QUESTION_SQL)){
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

    public boolean checkExistQuestion_withId(int id) {
        conn  = DBConfig.getConn();

        String CHECK_EXISTING_QUESTION_SQL = "SELECT id FROM question WHERE id = ?";
        ResultSet rs = null;
        try (
            PreparedStatement CHECK_PS = conn.prepareStatement(CHECK_EXISTING_QUESTION_SQL)){
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
