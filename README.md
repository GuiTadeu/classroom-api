# Alura API

A documentaçao da API (Swagger) se encontra no seguinte endereço: [alura-api](http://aluradev-api.herokuapp.com/).

Existe uma rota [/populate](http://aluradev-api.herokuapp.com/populate) para inserir dados no "banco".
 
## Funcionalidades
- [x] Implementar os métodos que estão no UserRepository
- [x] Criar um modelo para o curso
- [x] Criar um modelo para a matricula
- [x] Fazer um repositório para cada um deles
- [x] Criar um método que matricule um User em um curso
- [x] Criar um método que retorne se um usuário está matriculado em um curso ou não
- [x] Criar um método que retorne todos alunos que estão em um curso

## Resources

| HTTP           | ROUTES       | DESCRIPTION    |
| :------------: | :------------: | :------------: |
| GET | /courses | list |
| GET | /courses/{idCourse}/find/user/{idUser} | findUserInCourse |
| GET | /courses/{idCourse}/users | getAllUsersInCourse |
| POST| /courses/create | create |
| GET | /courses/find/id/{id} | findById |
| GET | /users | list |
| POST| /users/create | create |
| GET | /users/find/email/{email} | findByEmail |
| GET | /users/find/email/like/{emailPart} | findByEmailLike |
| GET | /users/find/id/{id} | findById |
| GET | /users/find/name/{name} | findByName |
| GET | /users/find/name/like/{namePart} | findByNameLike |
| POST| /registration/course/{idCourse}/user/{idUser} | register |
