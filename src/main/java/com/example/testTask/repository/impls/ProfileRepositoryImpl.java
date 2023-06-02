package com.example.testTask.repository.impls;

import com.example.testTask.repository.interfaces.ProfileRepository;
import com.example.testTask.repository.mappers.UsersMapper;
import com.example.testTask.repository.models.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.util.Optional;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private static final String SQL_GET_PROFILE_BY_ID =
            "select id from users where login = :log and password = :pass";

    private static final String SQL_INSERT_PROFILE =
            "insert into users (login, password) values (:login, :password)";

    private final UsersMapper profileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProfileRepositoryImpl(
            UsersMapper usersMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.profileMapper = usersMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getUser (String login, String password) {
        var params = new MapSqlParameterSource();
        params.addValue("log", login);
        params.addValue("pass", password);
        Optional<User> result = jdbcTemplate.query(
                        SQL_GET_PROFILE_BY_ID,
                        params,
                        profileMapper
                ).stream()
                .findFirst();
        if (result.isEmpty())
            return -1;
        return result.get().id();
    }

    @Override
    public void addUser(String login, String password) {
        var params = new MapSqlParameterSource();

        params.addValue("login", login);
        params.addValue("password", DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase());
        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }
}
