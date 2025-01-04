package ru.otus.socialnetwork.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.otus.socialnetwork.entity.UserAuth;
import ru.otus.socialnetwork.repository.query.UserQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private UserAuthRowMapper userAuthRowMapper = new UserAuthRowMapper();

    public UserAuth findByUsername(String username) {
        return jdbcTemplate.queryForObject(
                UserQuery.GET_ACCOUNT_BY_USERNAME.getQuery(),
                new MapSqlParameterSource()
                        .addValue("username", username),
                userAuthRowMapper);
    }

    private static class UserAuthRowMapper implements RowMapper<UserAuth> {
        @Override
        public UserAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new UserAuth()
                    .setId(rs.getLong("id"))
                    .setUsername(rs.getString("username"))
                    .setPassword(rs.getString("password"));
        }
    }

}
