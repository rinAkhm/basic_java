# Notes application 
## set up
Подтяните образ ```docker pull postgres:15.1```, затем
создайте volume командой ```docker volume create pgdata```.
Запустите приложение контайнер 
```
docker run --name database -p 5432:5432 -e POSTGRES_PASSWORD=secret -v pgdata:/var/lib/postgresql/data -d postgres:15.1
```



после чего к базе можно будет подключиться по порту 5432 (например из DBeaver или PgAdmin: host: localhost, port: 5432, user: postgres, pass: secret, database name: postgres)