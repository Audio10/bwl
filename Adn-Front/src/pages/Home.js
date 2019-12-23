import React, { Component } from "react";
import PageLoading from "../components/PageLoading";
import ItemList from "../components/ItemList";
import Header from "../components/Header";
import ModalCreate from "../components/ModalCreate";
import Status from "../components/Status";
import "./styles/Home.css";

const axios = require("axios").default;

export default class Home extends Component {
  constructor() {
    super();
    this.state = {
      loading: false,
      error: null,
      modalIsOpen: false,
      modal: {},
      status: false,
      data: []
    };
  }

  componentDidMount() {
    this.fetchData();
  }

  fetchData = async () => {
    this.setState({ loading: true, error: null });
    let data;
    try {
      await axios
        .get("http://adnbwl.us-east-2.elasticbeanstalk.com/mutation/all")
        .then(function(response) {
          data = response.data;
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  fetchDataN = async () => {
    this.setState({ loading: true, error: null });
    let data;
    try {
      await axios
        .get(
          "http://adnbwl.us-east-2.elasticbeanstalk.com/mutation/sinmutation"
        )
        .then(function(response) {
          data = response.data;
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  fetchDataM = async () => {
    this.setState({ loading: true, error: null });
    let data;
    try {
      await axios
        .get(
          "http://adnbwl.us-east-2.elasticbeanstalk.com/mutation/conmutation"
        )
        .then(function(response) {
          data = response.data;
        });
      this.setState({ data: data, loading: false });
    } catch (error) {
      this.setState({ loading: false, error: error });
    }
  };

  CreateHumano() {
    axios
      .post("http://adnbwl.us-east-2.elasticbeanstalk.com/humano", {
        name: this.state.modal.nombre
      })
      .then(response => {})
      .catch(e => {
        console.log(e);
      });
  }

  handleClickM = e => {
    this.setState({ status: false });
    this.fetchDataM();
  };

  handleClickSM = e => {
    this.setState({ status: false });
    this.fetchDataN();
  };

  handleClickE = e => {
    this.setState({ status: true });
  };

  handleCloseModal = e => {
    this.setState({ status: false });
    this.setState({ modalIsOpen: false });
    this.fetchData();
  };

  handleOpenModal = e => {
    this.setState({ modalIsOpen: true });
  };

  handleCreateModal = e => {
    this.CreateHumano();
    this.handleCloseModal();
    this.fetchData();
  };

  handleChanche = e => {
    this.setState({
      modal: {
        [e.target.name]: e.target.value
      }
    });
  };

  render() {
    if (this.state.loading === true && !this.state.data) {
      return <PageLoading />;
    }

    return (
      <React.Fragment>
        <Header />

        <div className="container-fluid">
          <div className="row navbar--color">
            <div className="col-md-6 col-lg-3  button--position">
              <div className="opaco">
                <button onClick={this.handleOpenModal}> Humano </button>
              </div>

              <ModalCreate
                isOpen={this.state.modalIsOpen}
                onCreate={this.handleCreateModal}
                onChange={this.handleChanche}
                onClose={this.handleCloseModal}
              />
            </div>
            <div className="col-md-6 col-lg-3 button__style button--position">
              <div className="opaco">
                <button onClick={this.handleClickE}> Estado </button>
              </div>
            </div>
            <div className="col-md-6 col-lg-3 button__style button--position">
              <div className="opaco">
                <button onClick={this.handleClickM}> Mutaciones </button>
              </div>
            </div>
            <div className="col-md-6 col-lg-3 button__style button--position">
              <div className="opaco">
                <button onClick={this.handleClickSM}> Sin Mutaciones </button>
              </div>
            </div>
          </div>
        </div>

        <div className="redondeado"></div>

        <div className="container-fluid container--position">
          {this.state.status === false ? (
            <ItemList items={this.state.data} />
          ) : (
            <Status />
          )}
        </div>
      </React.Fragment>
    );
  }
}
