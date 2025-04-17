// src/pages/LoginPage.js
import React, { useState } from "react";
import axios from "axios";
import { TextField, Button, Typography, Box } from "@mui/material";
import { useNavigate, useLocation } from "react-router-dom";

const LoginPage = () => {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const navigate = useNavigate();
  const location = useLocation();

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleLogin = async () => {
    try {
    const data = new URLSearchParams();
          data.append("username", formData.email);
          data.append("password", formData.password);

           const response = await axios.post("http://localhost:8080/login", data, {
            headers: {
              "Content-Type": "application/x-www-form-urlencoded",
            },
            withCredentials: true,
            validateStatus: () => true,
          });
          console.log("STATUS",response.status);
          console.log("DATA",response.data);
         if (response.status === 200) {
              alert("Login successful!");
              localStorage.setItem("userLoggedIn", "true");
              navigate("/home");
            } else if(response.status === 401 || response.status === 404){
              alert("Login failed" + response.data.message || "Invalid credentials.");
            }
            else
            {
               alert("Login failed: Unexpected error");
            }
    } catch (error) {
      alert("Login failed. Check credentials.");
    }
  };

  return (
    <Box textAlign="center" mt={10}>
      <Typography variant="h4">Login</Typography>
      <TextField
        name="email"
        label="Email"
        variant="outlined"
        fullWidth
        margin="normal"
        value={formData.email}
        onChange={handleChange}
      />
      <TextField
        name="password"
        label="Password"
        type="password"
        variant="outlined"
        fullWidth
        margin="normal"
        value={formData.password}
        onChange={handleChange}
      />
      <Button variant="contained" color="primary" onClick={handleLogin}>
        Login
      </Button>
    </Box>
  );
};

export default LoginPage;
