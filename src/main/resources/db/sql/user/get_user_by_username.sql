select a.id
     , a.username
     , a.password
  from "user" a
 where a.username = :username
