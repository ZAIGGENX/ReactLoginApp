import { Fragment } from "react/jsx-runtime";
import LoginComponent from "./LoginComponent";
import Register from "./Register";

function CardComponent(){
return ( 
    <Fragment>
        <div className="login-card">
            <h1>Login</h1>
            <div className="card">
                    <img src="../assets/card_bg_01.png" className="card-img-top" alt="..."/>
                <div className="card-body">
                    {/* <LoginComponent></LoginComponent> */}
                    <Register></Register>
                </div>
            </div>
        </div>
    </Fragment>
    );
}

export default CardComponent;

