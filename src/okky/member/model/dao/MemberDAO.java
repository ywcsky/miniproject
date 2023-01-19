package okky.member.model.dao;

import okky.member.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
    public int findMember(String userId, String userPw, Connection conn) {
        String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
        int result = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,userPw);
            ResultSet rset = pstmt.executeQuery();
            if(rset.next()){
                result = rset.getInt(1);
            }
            rset.close();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
