package ru.otus.socialnetwork.repository.query;

import io.undertow.util.FileUtils;

public enum UserQuery {

    GET_ACCOUNT_BY_USERNAME("db/sql/user/get_user_by_username.sql"),

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
