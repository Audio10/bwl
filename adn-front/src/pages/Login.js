import React, { Component } from 'react'
import "./styles/Login.css";
import LoginForm from '../components/LoginForm'

export default class Login extends Component {
    render() {
        return (
            <div className="container-fluid">
                <div className="circulo circulo--izquierdo"> </div>
                <div className="circulo circulo--arriba"> </div>
                <div className="circulo circulo--medio"> </div>
                <h1 className="text--aling">TEST</h1>

                <div className="row">
                    <div className="col-10 formulario--izquierda">
                        <LoginForm />
                    </div>
                </div>
            </div>


        )
    }
}