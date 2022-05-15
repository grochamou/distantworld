# DistantWorld Server
heroku apps:destroy --app gcm-distantworld-server --confirm gcm-distantworld-server
heroku apps:create --region eu gcm-distantworld-server
heroku config:set --app gcm-distantworld-server SPRING_PROFILES_ACTIVE=heroku
./mvnw heroku:deploy-war -f distantworld-server/pom.xml -Pheroku

# DistantWorld Client
heroku apps:destroy --app gcm-distantworld-client --confirm gcm-distantworld-client
heroku apps:create --region eu gcm-distantworld-client
heroku config:set --app gcm-distantworld-client SPRING_PROFILES_ACTIVE=heroku
./mvnw heroku:deploy-war -f distantworld-client/pom.xml -Pheroku
