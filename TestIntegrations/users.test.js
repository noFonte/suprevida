const { default: axios } = require("axios");
const MyFn = require("./Helpers.js")
const url ="http://localhost:8080";


test('criar um novo usuário',async () => {

    inputUser={
        "login":MyFn.uuid(),
        "password":MyFn.uuid()
    }
    outputUser = await axios.post(url+"/register",inputUser)
    expect(outputUser.status).toBe(201)
});



test('criar um novo usuário se o login não existir',async () => {

    inputUser={
        "login":MyFn.uuid(),
        "password":MyFn.uuid()
    }
    outputUser = await axios.post(url+"/register",inputUser)
    expect(outputUser.status).toBe(201)
});
