package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.bean.AdminBean;

@Repository
public class AdminDao {

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addAdmin(AdminBean adminBean) {

		return jdbcTemplate.update("insert into admin(aname,aemail,apassword)values('" + adminBean.getaName() + "','"
				+ adminBean.getaEmail() + "','" + adminBean.getaPassword() + "')");
	}
	public AdminBean loginAdmin(AdminBean adminBean){
		
		
		return jdbcTemplate.queryForObject("select * from admin where aemail ='"+adminBean.getaEmail()+"' and apassword ='"+adminBean.getaPassword()+"'", new AdminMpper());
	}

	private final static class AdminMpper implements RowMapper<AdminBean> {

		public AdminBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			AdminBean adminBean = new AdminBean();

			adminBean.setaId(rs.getInt("aid"));
			adminBean.setaName(rs.getString("aname"));
			adminBean.setaEmail(rs.getString("aemail"));
			adminBean.setaPassword(rs.getString("apassword"));

			return adminBean;
		}

	}

	public int deleteAdmin(int aId) {

		return jdbcTemplate.update("delete from admin where aid =" + aId + "");
	}

	public List<AdminBean> listOfAdmins() {

		return jdbcTemplate.query("select * from admin", new AdminMpper());
	}

	
	public AdminBean getDataById(int aId) {

		return jdbcTemplate.queryForObject("select * from admin where aid =" + aId + "", new AdminMpper());
	}
	

	public int updateAdmin(AdminBean adminBean) {

		return jdbcTemplate.update("update admin set aname =?,aemail=?,apassword=? where aid = ?", adminBean.getaName(),
				adminBean.getaEmail(), adminBean.getaPassword(), adminBean.getaId());
	}
	public int updateAdmin1(AdminBean adminBean) {

		return jdbcTemplate.update("update admin set aname =?,apassword=? where aemail = ?", adminBean.getaName(),
				 adminBean.getaPassword(),adminBean.getaEmail());
	}
	
	/*public AdminBean getDataById(int id){
		
		
		
		return jdbcTemplate.queryForObject("select * from admin where aid ="+id+"", new AdminMpper());
	}*/

}
