java -Dspring.profiles.active=heroku -jar distantworld-server/target/distantworld-server*.war &
java -Dspring.profiles.active=heroku -jar distantworld-client/target/distantworld-client*.war &
