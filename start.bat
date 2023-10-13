cd ./frontend && start "Frontend" npm start
cd ./../generator && start "Generator" mvn spring-boot:run
cd ./../validator && start "Validator" mvn spring-boot:run
