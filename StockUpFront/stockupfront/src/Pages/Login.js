import React, { useState } from 'react';
import Button from "../Components/Button";
import InputFields from "../Components/InputFields";

function Login(props) {
    // State to store the form input values
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

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

        // Validate the inputs
        if (email.length === 0) {
            alert("Email is required!");
            return;
        }
        if (password.length === 0) {
            alert("Password is required!");
            return;
        }

        // Log the form data
        alert("Form submitted! Email:"+ email + "Password:" + password);

        // Optionally, send data to a server (example with fetch)
        /*
        fetch("/api/login", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify({ email, password })
        })
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('Error:', error));
        */
    };

    return (
        <div style={div_login}>
            <div style={div_title}>
                <p>Login</p>
            </div>

            <form onSubmit={handleSubmit}>
                {/* Email Input */}
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

                {/* Password Input */}
                <InputFields
                    title={"Password:"}
                    title_color={"black"}
                    color_option={"grey"}
                    borderRadius={"5px"}
                    width={"250px"}
                    type={"password"}
                    marginLeft={"110px"}
                    marginTop={"50px"}
                    onChange={(e) => setPassword(e.target.value)} // Update password state on change
                />

                {/* Submit Button */}
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
        </div>
    );
}

export default Login;