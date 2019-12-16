import React, { Component } from "react";
import Header from "../components/Header";
import PageLoading from "../components/PageLoading";
import ItemList from "../components/ItemList";
import "./styles/Home.css";

const axios = require("axios").default;

export default class Home extends Component {
  state = {
    loading: false,
    error: null,
    data: [
      {}
    ]
  };

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async () => {
    this.setState({ loading: true, error: null });
    let data;
    try {
      await axios
        .get("http://localhost:8090/mutation/all")
        .then(function(response) {
          data = response.data;
          console.log(data);
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }

    console.log(this.state.data);
  };

  fetchDataN = async () => {
    this.setState({ loading: true, error: null });
    let data;
    try {
      await axios
        .get("http://localhost:8090/mutation/sinmutation")
        .then(function(response) {
          data = response.data;
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }

    console.log(this.state.data);
  };

  fetchDataM = async () => {
    this.setState({ loading: true, error: null });
    let data;
    console.log("...");
    try {
      await axios
        .get("http://localhost:8090/mutation/conmutation")
        .then(function(response) {
          data = response.data;
          console.log(data);
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }

    console.log(this.state.data);
  };

  handleClickN = e => {
    
  };

  handleClickM = e => {
    console.log('CON MUTATION')
    this.fetchDataM()
  };

  handleClickSM = e => {
    console.log('SIN MUTACION');
    this.fetchDataN()
  };

  handleClickE = e => {
    console.log('Nuevo');
  };
  render() {
    if (this.state.loading === true && !this.state.data) {
      return <PageLoading />;
    }

    return (
      <React.Fragment>
        <div className="container-superior">
          <Header />

          <div className="container-fluid row">
            <div className="col-3 item">
              <button className="nav__button" onClick={this.handleClickN}> Nuevo humano </button>
            </div>
            <div className="col-3 item">
              <button className="nav__button" onClick={this.handleClickE}> Analizar Humano </button>
            </div>
            <div className="col-3 item">
              <button className="nav__button" onClick={this.handleClickM}> Con Mutacion </button>
            </div>
            <div className="col-3 item">
              <button className="nav__button" onClick={this.handleClickSM}> Sin Mutacion </button>
            </div>
          </div>

          <ItemList  items={this.state.data} />


        </div>

        
      </React.Fragment>
    );
  }
}
