const { default: axios } = require("axios");
const MyFn = require("./Helpers.js")
axios.defaults.baseURL ="http://localhost:8080";


test('criar um novo usuário',async () => {

    inputUser={
        "login":MyFn.uuid(),
        "password":MyFn.uuid()
    }
    outputUser = await axios.post("/register",inputUser)
    expect(outputUser.code).toBe(201)
  });