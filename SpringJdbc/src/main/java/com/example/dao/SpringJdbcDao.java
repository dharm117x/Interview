package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.pojo.Employee;

@Repository
public class SpringJdbcDao {

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	TransactionTemplate transactionTemplate;

	public SpringJdbcDao() {
		System.out.println(dataSource + "-----" + jdbcTemplate);
	}

	@PostConstruct
	public void after() {
		System.out.println(dataSource + "-----" + jdbcTemplate);
	}

	String sql = "select id, empno, ename, job, sal from Employee";

	public Employee addEmployee(Employee emp) {
		int update = jdbcTemplate.update("insert into Employee(empno, ename, job, sal) values(?, ?, ?, ?)", emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getSalary());
		if(update>0) {
			System.out.println("SpringJdbcDao.addEmployee() ok");
		}else {
			System.out.println("SpringJdbcDao.addEmployee() nok");
		}
		return null;
	}

	public void updateEmp() {
		transactionTemplate.execute(new TransactionCallback<Employee>() {

			public Employee doInTransaction(TransactionStatus status) {
				String upSql = "update employes set sal=? where job = ?";
				try {
					jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

						public void setValues(PreparedStatement ps, int i) throws SQLException {
							ps.setString(1, "");
							ps.setString(2, "");
						}

						public int getBatchSize() {
							return 5;
						}
					});

				} catch (Exception e) {
					status.setRollbackOnly();
				}

				return null;
			}
		});

	}

	public List<Employee> empSearch() {

		List<Employee> list1 = jdbcTemplate.query(sql, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int i) throws SQLException {
				return createEmployee(rs);
			}
		});

		System.out.println("list1:::" + list1);

		List<Employee> list2 = jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Employee> datas = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp = createEmployee(rs);
					datas.add(emp);
				}
				return datas;
			}
		});

		System.out.println("list2:::" + list2);

		List<Employee> list3 = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		System.out.println("list3:::" + list3);

		return list1;
	}

	protected Employee createEmployee(ResultSet rs) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpno(rs.getString("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setJob(rs.getString("job"));
		emp.setSalary(rs.getDouble("sal"));
		return emp;
	}

}
