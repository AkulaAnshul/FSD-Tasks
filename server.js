import http from 'http';
import express from 'express';
import users from './users.json' with { type: 'json' };
import fs, { writeFileSync } from 'fs';
const app = express();
app.use(express.json())
app.get("/",(req,res)=>{
    res.send("Hello Rui");
});

app.get("/users",(req,res)=>{
    res.json(users);
})

app.get("/users/:id", (req, res) => {
    const id = parseInt(req.params.id); 
    const user = users.find(u => u.id === id);
    if (!user) {
        return res.status(404).send("User not found");
    }
    res.json(user);
});

app.post("/addUser",(req,res)=>{
    const { id,firstName, lastName, mobile, email } = req.body
    const newUser = {
        id: id,
        firstName: firstName,
        lastName: lastName,
        mobile: mobile,
        email: email
    };

    users.push(newUser);
    fs.writeFileSync('users.json',JSON.stringify(users))
    res.status(200).json(newUser);
})

app.put("/updateUser/:id",(req,res)=>{
    const id = parseInt(req.params.id)
    const { firstName, lastName, mobile, email } = req.body;
    const index = users.findIndex(u => u.id === id);
    if (index ==-1) {
            return res.status(404).send("User not found");
        }
    users[index] = {
        id: id,
        firstName: firstName,
        lastName: lastName,
        mobile: mobile,
        email: email
    };
    fs.writeFileSync('users.json',JSON.stringify(users))
    res.json({
    message: "User updated successfully",
    updatedUser: users[index]
    });
})

app.patch("/updateUser/:id",(req,res)=>{
    const id = parseInt(req.params.id)
    const index = users.findIndex(u=>u.id==id);
    if(index==-1){
        res.send("User Not found");
    }
    if (req.body.firstName) users[index].firstName = req.body.firstName;
    if (req.body.lastName)  users[index].lastName  = req.body.lastName;
    if (req.body.mobile)    users[index].mobile    = req.body.mobile;
    if (req.body.email)     users[index].email     = req.body.email;
    fs.writeFileSync('users.json',JSON.stringify(users))
    res.json({
    message: "User patched successfully",
    updatedUser: users[index]
    });
})

app.delete("/deleteUser/:id",(req,res)=>{
    const id =  parseInt(req.params.id);
    const index = users.findIndex(u => u.id === id);
    if (index === -1) {
        return res.status(404).send("No user found");
    }
    const deletedUser = users[index];
    users.splice(index, 1);
    fs.writeFileSync("users.json",JSON.stringify(users))
    res.json({
        message: "User deleted successfully",
        deletedUser: deletedUser
    });
})

app.listen(2000,()=>{
    console.log("Server is running on port 2000");
});