/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjdbc.repository.impl;

import com.fon.silab.spring.springjdbc.domain.User;
import com.fon.silab.spring.springjdbc.repository.UserRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Korisnik
 */
@Component
//@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource datasource) {
        jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<User> getAll() {
        System.out.println("com.fon.silab.spring.springjpa.repository.impl.UserRepositoryImpl.getAll()");
        String query = "select * from user";
        return jdbcTemplate.query(query, new UserMapper());
    }

    @Override
    public User getById(Long id) {
        String query = "select * from user WHERE user_id = ?";
        User usr = jdbcTemplate.queryForObject(query, new Object[]{id}, new UserMapper());
        return usr;
    }

    @Override
    public void add(User user) {
        System.out.println("com.fon.silab.spring.springjpa.repository.impl.UserRepositoryImpl.add()");
        jdbcTemplate.update(
                "INSERT INTO user (firstname, lastname, email, password) VALUES (?, ?,?,?)",
                user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword()
        );
    }

    class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            System.out.println("int i: "+i);
            User user = new User();
            user.setId(rs.getLong("user_id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));

            return user;
        }

    }

}
