import React, { Component } from "react"
import './styles/LoginForm.css'
export default class LoginForm extends Component {
    render() {
        return (
            <div className="conatiner formulario">
                
                <div className="row formulario--centra">
                    <div className="col-12">
                        <input
                            onChange={this.props.onChange}
                            className="formulario__input"
                            type="text"
                            name="usuario"
                            placeholder="Usuario"
                        />
                    </div>

                    <div className="col-12">
                        <input
                            onChange={this.props.onChange}
                            className="formulario__input"
                            type="password"
                            name="psw"
                            placeholder="Password"
                        />
                    </div>

                    <div className="col-12 formulario__button--position">
                        <button
                            type="submit"
                            onClick={this.handleClick}
                            className="btn btn-warning formulario__button--radius"
                        >
                            Ingresar
                    </button>
                    </div>
                </div>

            </div>
        );
    }
}