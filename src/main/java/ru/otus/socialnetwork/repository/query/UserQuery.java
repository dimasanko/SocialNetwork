package ru.otus.socialnetwork.repository.query;

import io.undertow.util.FileUtils;
import lombok.Getter;

public enum UserQuery {

    GET_ACCOUNT_BY_USERNAME("db/sql/account/get_account_by_username.sql"),

    ;

    UserQuery(String sqlFilePath) {
        this.query = FileUtils.readFile(ClassLoader.getSystemClassLoader()
                .getResource(sqlFilePath));
    }

    public final String query;

    public String getQuery() {
        return query;
    }

}
