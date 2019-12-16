import React, { Component } from "react";
import "./styles/LoginForm.css";
export default class LoginForm extends Component {

  handleClick = e => {
    console.log("Button was clicked");
  };

  handleSubmit = e => {
    e.preventDefault();
    console.log("Form was submitted");
  };

  render() {
    return (
      <div className="conatiner formulario">
        <form className="row formulario--centra" onSubmit={this.props.onSubmit}>
          <div className="col-sm-12 form-group">
            <input
              onChange={this.props.onChange}
              className="formulario__input"
              type="text"
              name="usuario"
              placeholder="Usuario"
              value={this.props.formValues.usuario}
            />
          </div>

          <div className="col-12">
            <input
              onChange={this.props.onChange}
              className="formulario__input"
              type="password"
              name="password"
              placeholder="Password"
              value={this.props.formValues.password}
            />
          </div>

          <div className="col-12 formulario__button--position">
            <button
              type="submit"
              onClick={this.props.onSubmit}
              className="btn btn-warning formulario__button--radius"
            >
              Ingresar
            </button>

            {this.props.error && (
              <p className="text-danger"> "Verifica tu Usuario y Contraseña" </p>
            )}

          </div>
        </form>
      </div>
    );
  }
}
