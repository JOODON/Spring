package DTO.DAO;

import DTO.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Repository //알려주는 객체
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;//jdbc 템플릿을 사용한다는 뜻!
    private SimpleJdbcInsert insertAction;
    private RowMapper<Role> rowMapper= BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource){
        this.jdbc=new NamedParameterJdbcTemplate(dataSource);
    }
    public List<Role> selectAll(){
        return  jdbc.query(RoleDaoSql.SELECT_ALL, Collections.emptyMap(),rowMapper);

    }

}
