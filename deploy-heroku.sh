# DistantWorld Server
heroku apps:destroy --app distantworld-server --confirm distantworld-server
heroku apps:create --region eu distantworld-server
heroku config:set --app distantworld-server SPRING_PROFILES_ACTIVE=heroku
./mvnw heroku:deploy-war -f distantworld-server/pom.xml -Pheroku

# DistantWorld Client
heroku apps:destroy --app distantworld-client --confirm distantworld-client
heroku apps:create --region eu distantworld-client
heroku config:set --app distantworld-client SPRING_PROFILES_ACTIVE=heroku
./mvnw heroku:deploy-war -f distantworld-client/pom.xml -Pheroku
