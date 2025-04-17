// src/pages/AuthPage.js
import React, { useState } from "react";
import LoginPage from "./LoginPage";
import SignupPage from "./SignupPage";

const AuthPage = () => {
  const [isLogin, setIsLogin] = useState(true);

  const toggleForm = () => {
    setIsLogin(!isLogin);
  };

  return (
    <div>
      {isLogin ? (
        <>
          <LoginPage />
          <p style={{ textAlign: "center" }}>
            Don't have an account?{" "}
            <span
              onClick={toggleForm}
              style={{ color: "blue", cursor: "pointer" }}
            >
              Sign up
            </span>
          </p>
        </>
      ) : (
        <>
          <SignupPage />
          <p style={{ textAlign: "center" }}>
            Already have an account?{" "}
            <span
              onClick={toggleForm}
              style={{ color: "blue", cursor: "pointer" }}
            >
              Log in
            </span>
          </p>
        </>
      )}
    </div>
  );
};

export default AuthPage;
