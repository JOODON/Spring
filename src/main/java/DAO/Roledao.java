package DAO;

import DTO.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import static DAO.DAOSQL.*;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;


@Repository //저장소라는객체를 선언해주는 느낌으로 생각하자!
public class Roledao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public Roledao (DataSource dataSource){
        this.jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }
    public List<Role> selectAll(){
        return jdbcTemplate.query(SELECT_ALL, Collections.emptyMap(),rowMapper);
                //쿼리문,비어있는 맵 객체
    }

}
