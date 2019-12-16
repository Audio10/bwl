import React, { Component } from "react";
import "./styles/Login.css";
import LoginForm from "../components/LoginForm";
const axios = require('axios').default;

export default class Login extends Component {
  state = {
    loading: false,
    error: null,
    form: {
      usuario: "",
      password: ""
    }
  };

  handleChange = e => {
    this.setState({
      form: {
        ...this.state.form,
        [e.target.name]: e.target.value
      }
    });
  };

  handleSubmit = async e => {
    // Funciona para detener una llamada
    e.preventDefault();
    this.setState({ loading: true, error: null });

    try {
    await axios.post("http://localhost:8090/users/login", {
        "name": this.state.form.usuario,
        "password": this.state.form.password
      }).then(function (response) {
        console.log(response);
        window.location = '/home';
      })
      
      this.setState({ loading: false });

    } catch (error) {
      console.log(error)
      this.setState({ loading: false, error: error });
    }
  };

  render() {

    return (
      <div className="fondo">
        <div className="container-fluid">
          <div className="circulo circulo--izquierdo"> </div>
          <div className="circulo circulo--arriba"> </div>
          <div className="circulo circulo--medio"> </div>
          <h1 className="text--aling">TEST</h1>

          <div className="row">
            <div className="col-sm-12 col-lg-10 formulario--izquierda">
              <LoginForm
                onSubmit= {this.handleSubmit}
                onChange={this.handleChange}
                formValues={this.state.form}
                error={this.state.error}
              />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
