import React, { Component } from "react";

import "./styles/Status.css";

const axios = require("axios").default;
export default class Status extends Component {
    constructor() {
        super()
        this.state = {
            data: {
                con: 0,
                sin: 0,
                ratio: 0
            }
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
                .get("http://adnbwl.us-east-2.elasticbeanstalk.com/mutation/status")
                .then(function (response) {
                    data = response.data;
                });
            this.setState({ data: data, loading: false });
            console.log(this.state.data.con)
        } catch (error) {
            this.setState({ loading: false, error: error });
        }
    };

    render() {
        return (
            <div className="container estatus__container">
                <div className="row estatus__data">
                    <div className="col-12 estatus__titulo">
                        <h1>ADN detector</h1>
                    </div>
                    <div className="col-sm-12 col-md-6">
                        <h2>Con Mutacion: </h2>
                    </div>
                    <div className="col-sm-12 col-md-6">
                        <h2>{this.state.data.con}</h2>

                    </div>
                    <div className="col-sm-12 col-md-6">
                        <h2>Sin Mutacion:</h2>
                    </div>
                    <div className="col-sm-12 col-md-6">
                        <h2>{this.state.data.sin}</h2>
                    </div>
                </div>
            </div>
        );
    }
}