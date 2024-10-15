import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from "../Components/Button";
import InputFields from "../Components/InputFields";
import Popup from "../Components/PopUp";

function Login(props) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [popupMessage, setPopupMessage] = useState('');
    const [showPopup, setShowPopup] = useState(false);
    const navigate = useNavigate(); // Usando o hook useNavigate

    const div_login = {
        background: 'white',
        height: "500px",
        width: "600px",
        borderRadius: '10px',
    };

    const div_title = {
        color: 'black',
        textAlign: 'center',
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        if (email.length === 0) {
            setPopupMessage("Email is required!");
            setShowPopup(true);
            return;
        }
        if (password.length === 0) {
            setPopupMessage("Password is required!");
            setShowPopup(true);
            return;
        }

        const loginData = { email, password };

        fetch('http://localhost:8080/authenticate_user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(loginData),
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Login failed');
                }
                return response.json();
            })
            .then(data => {
                setPopupMessage("Login successful");
                setShowPopup(true);

                console.log('Login successful:', data);

                sessionStorage.setItem('managerData', JSON.stringify(data));
                navigate('/cadastrar-produto');
            })
            .catch(error => {
                setPopupMessage('Email or password are incorrect');
                setShowPopup(true);
                console.error('Error during login:', error);
            });
    };

    return (
        <div style={div_login}>
            <div style={div_title}>
                <p>Login</p>
            </div>

            <form onSubmit={handleSubmit}>
                <InputFields
                    title={"Email:"}
                    title_color={"black"}
                    color_option={"grey"}
                    borderRadius={"5px"}
                    width={"250px"}
                    marginLeft={"110px"}
                    onChange={(e) => setEmail(e.target.value)}
                    required={"required"}
                    type={"email"}
                />

                <InputFields
                    title={"Password:"}
                    title_color={"black"}
                    color_option={"grey"}
                    borderRadius={"5px"}
                    width={"250px"}
                    type={"password"}
                    marginLeft={"110px"}
                    marginTop={"50px"}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <Button
                    color_option={"green"}
                    width={"200px"}
                    height={"30px"}
                    text={"Login"}
                    font_color={"White"}
                    borderRadius={"10px"}
                    type="submit"
                    marginLeft={"200px"}
                    marginTop={"100px"}
                />
            </form>

            {/* Show the Popup if showPopup is true */}
            {showPopup && (
                <Popup
                    message={popupMessage}
                    onClose={() => setShowPopup(false)}
                />
            )}
        </div>
    );
}

export default Login;
