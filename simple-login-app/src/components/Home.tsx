import { Fragment } from "react/jsx-runtime";
import LoginComponent from "./LoginComponent";
import Register from "./Register";
import {useLocation} from 'react-router-dom';

function Home(){
    const location = useLocation();
    return ( 
        <Fragment>
            <div className="login-card">
                <h1>Home Page</h1>
                <div className="card">
                <img src="../src/assets/home_bg_01.png" className="card-img-top" alt="..."/>
                    <div className="card-body">
                        HOME PAGE Welcome! <h1>{location.state.userName}</h1>
                    </div>
                </div>
            </div>
        </Fragment>
    );
}

export default Home;

