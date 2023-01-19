package okky.member.model.service;

import okky.common.JDBCTemplate;
import okky.member.model.dao.MemberDAO;
import okky.member.model.vo.Member;

import java.sql.Connection;

public class MemberService {
    MemberDAO mDao;
    public MemberService(){
        mDao = new MemberDAO();
    }
    public int findMember(String userId, String userPw) {
        Connection conn = JDBCTemplate.getConnection();
        return mDao.findMember(userId,userPw,conn);
    }
}
