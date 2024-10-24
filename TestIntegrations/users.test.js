const { default: axios } = require("axios");
const MyFn = require("./Helpers.js")
const url = "http://localhost:8080";

const instance = axios.create({
    validateStatus: () => true,
});


test('criar um novo usuário', async () => {

    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)
});



test('criar um novo usuário se o login não existir', async () => {

    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)

    outputUser2 = await instance.post(url + "/register", inputUser, { validateStatus: false })
    expect(outputUser2.status).toBe(400)


});



test('Listar Todos Usuarios Cadastrados Na Base', async () => {
    outputUsers = await instance.get(url + "/users")
    expect(outputUsers.data.users.length).toBeGreaterThan(0);
});


test('Busca um Usuario Cadastrado Na Base', async () => {
    inputUser = {
        "login": MyFn.uuid(),
        "password": MyFn.uuid()
    }
    outputUser = await instance.post(url + "/register", inputUser)
    expect(outputUser.status).toBe(201)
    outputUser = await instance.post(url + "/user",inputUser)
   expect(outputUser.data.user.id).toBeGreaterThan(0);
});