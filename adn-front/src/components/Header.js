import React, { Component } from "react";

import "./styles/Header.css";

export default class Header extends Component {
  render() {
    return (
      
        <div className="container-fluid row">
          <div className="col-lg-6 header__izquierda">
            <h1> ADN Detector</h1>
          </div>
          <div className="col-lg-6 header__derecha">
            <p>menu</p>
          </div>
        </div>
    
    );
  }
}
