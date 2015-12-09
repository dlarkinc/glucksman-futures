package io.larkin.glucksman.futures.domain.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.larkin.glucksman.futures.domain.Question;

public class QuestionMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int arg1) throws SQLException {
		
		Question question = new Question();
		question.setPage(rs.getInt("page"));
		question.setQuestion(rs.getString("question"));
		question.setSlot1(rs.getString("slot1"));
		question.setSlot2(rs.getString("slot2"));
		question.setSlot3(rs.getString("slot3"));
		question.setDesc1(rs.getString("desc1"));
		question.setDesc2(rs.getString("desc2"));
		question.setDesc3(rs.getString("desc3"));
		
		return question;
	}
	
}
