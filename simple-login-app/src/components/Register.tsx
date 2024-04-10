import {  useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
function Register() {
  
    const [userName, setUserName] = useState("");
    const [userMail, setUserEmail] = useState("");
    const [userPassword, setUserPassword] = useState("");
    const navigate = useNavigate();
    
    async function save(event) {
        event.preventDefault();

        if ('' === userName) {
            alert("Username Empty");
          return
        }

        if ('' === userMail) {
            alert("userMail Empty");
          return
        }
      
        if ('' === userPassword) {
            alert("userPassword Empty");
          return
        }
      
        try {
          await axios.post("http://localhost:8085/app/login/user/save", {
            userName: userName,
            userMail: userMail,
            userPassword: userPassword,
          }).then((res) => 
            { 
                console.log(res.data.message);
                alert(res.data.message);
            }, fail => {
                console.error(fail); // Error!
          });
          
        } catch (err) {
          alert(err);
        }
      }

    //Navigation Definitions
    const toLogin=()=>{ navigate('/login',{state:{id:1}}); }
  
    return (
    <div>
    <div className="login-card" >
        <div className="card">
        <img src="../src/assets/card_bg_01.png" className="card-img-top" alt="..."/>
        <h2>User Registation</h2>
            <form>
                <div className="form-group">
                <label>User Name</label>
                <input type="text"  className="form-control" id="userName" placeholder="Enter Name"
                value={userName}
                onChange={(event) => {
                    setUserName(event.target.value);
                }}
                />
                </div>
                <div className="form-group">
                <label>Email</label>
                <input type="email"  className="form-control" id="userMail" placeholder="Enter Email"
                
                value={userMail}
                onChange={(event) => {
                    setUserEmail(event.target.value);
                }}
                />
        
                </div>
                <div className="form-group">
                    <label>Password</label>
                    <input type="password"  className="form-control" id="userPassword" placeholder="Enter Password"
                    
                    value={userPassword}
                    onChange={(event) => {
                    setUserPassword(event.target.value);
                    }}
                    />
                </div>
                <button type="submit" className="btn btn-primary mt-4" onClick={save} >Save</button>
            </form>
            <a onClick={()=>{toLogin()}} className="link-info">User Login</a>
            </div>
        </div>
     </div>
    );
  }
  
  export default Register;