package DAO;

import DTO.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import static DAO.DAOSQL.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;


@Repository //저장소라는객체를 선언해주는 느낌으로 생각하자!
public class Roledao {
    private NamedParameterJdbcTemplate jdbcTemplate;//JDBC 템플릿을 활용하기 위한 객체!
    private SimpleJdbcInsert simpleJdbcInsert;//Insert문 활용하기 위한 객체라고 생각하면 될듯! 
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public Roledao (DataSource dataSource){
        this.jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert =new SimpleJdbcInsert(dataSource).withTableName("role");
        //어떤 테이블을 사용할 것인가라고 이름을 지정해준다
    }
    public List<Role> selectAll(){
        return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(),rowMapper);
                //쿼리문,비어있는 맵 객체
    }
    public int insert(Role role){
        SqlParameterSourceSource params = new BeanPropertySqlParameterSource(role);
        return simpleJdbcInsert.execute(parameters);
    }

}
