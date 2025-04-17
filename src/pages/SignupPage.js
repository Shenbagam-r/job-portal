// src/pages/SignupPage.js
import React, { useState } from "react";
import axios from "axios";
import { TextField, Button, Typography, Box, MenuItem } from "@mui/material";

const SignupPage = () => {
  const [formData, setFormData] = useState({
    username: "",
    email: "",
    password: "",
    role: "",
  });

  const roles = ["USER", "ADMIN"]; // Enum-like values matching backend

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSignup = async () => {
    try {
      const res = await axios.post("http://localhost:8080/api/auth/signup", formData);
      alert("Signup successful!");
      console.log(res.data);
    } catch (error) {
      alert("Signup failed. Check details.");
    }
  };

  return (
    <Box textAlign="center" mt={10}>
      <Typography variant="h4">Sign Up</Typography>
      <TextField
        name="username"
        label="Username"
        fullWidth
        margin="normal"
        value={formData.username}
        onChange={handleChange}
      />
      <TextField
        name="email"
        label="Email"
        fullWidth
        margin="normal"
        value={formData.email}
        onChange={handleChange}
      />
      <TextField
        name="password"
        label="Password"
        type="password"
        fullWidth
        margin="normal"
        value={formData.password}
        onChange={handleChange}
      />
      <TextField
        name="role"
        label="Role"
        select
        fullWidth
        margin="normal"
        value={formData.role}
        onChange={handleChange}
      >
        {roles.map((role) => (
          <MenuItem key={role} value={role}>
            {role}
          </MenuItem>
        ))}
      </TextField>
      <Button variant="contained" color="primary" onClick={handleSignup}>
        Sign Up
      </Button>
    </Box>
  );
};

export default SignupPage;
