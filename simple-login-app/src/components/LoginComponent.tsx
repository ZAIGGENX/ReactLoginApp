import { Fragment } from "react/jsx-runtime";
import React, { useState } from 'react'
import '../App.css'
import { useNavigate } from 'react-router-dom';
import axios from "axios";
//import bcrypt from 'bcryptjs'

    function LoginComponent() {

        const [userName, setUserName] = useState("");
        const [userPassword, setUserPassword] = useState("");
        const [userError, setUserError] = useState("");
        const [passwordError, setPasswordError] = useState("");
        const navigate = useNavigate();
  
          async function login(event) {
              event.preventDefault();
              try {
                await axios.post("http://localhost:8085/app/login/user/login", {
                  userName: userName,
                  userPassword: userPassword,
                  }).then((res) => 
                  {
                    console.log(res.data);
                    
                    if (res.data.message == "User not exits") 
                    {
                      alert("User not exits");
                    } 
                    else if(res.data.message == "Login Success")
                    { 
                        navigate('/home', {state:{userName:userName}});
                        //alert("LOGIN SUCCESS!");
                    } 
                      else 
                    { 
                        alert("Incorrect User Name and Password, not match");
                    }
                  }, fail => {
                 console.error(fail); // Error!
                });
              }
       
               catch (err) {
                alert(err);
              }
            
            }

        const onButtonClick = () => {
            setUserError('')
            setPasswordError('')
          
            if ('' === userName) {
                setUserError('Please enter a user')
              return
            }
          
            if ('' === userPassword) {
              setPasswordError('Please enter a password')
              return
            }
          
            if (userPassword.length < 7) {
              setPasswordError('The password must be 8 characters or longer')
              return
            }

            //login(); ///////<----
        }

        const toRegister=()=>{ navigate('/register',{state:{id:1}}); }

         return (
            <Fragment>
              <div className="login-card">
                <div className="card">
                <img src="../src/assets/card_bg_01.png" className="card-img-top" alt="..."/>
                  <div className="login-card-content">
                    <h2>User Login</h2>
                      <form>
                          <label className="form-label">User</label>
                          <input type="text" 
                                className="form-control"
                                value={userName}
                                onChange={(ev) => setUserName(ev.target.value)}
                                />
                          <label className="form-label">Password</label>
                          <input type="password" 
                                className="form-control"
                                id="exampleInputPassword1"
                                value={userPassword}
                                onChange={(ev) => setUserPassword(ev.target.value)}
                                />
                      <label className="errorLabel">{userError}</label>
                      <label className="errorLabel">{passwordError}</label>
                      <button type="submit" className="btn btn-primary" onClick={login} value={'Log in'}>Submit</button>
                      </form>
                  </div>
                  <a onClick={()=>{toRegister()}} className="link-info">New User Registration</a>
                </div>
              </div>
            </Fragment>
        )

    }

    

    export default LoginComponent;