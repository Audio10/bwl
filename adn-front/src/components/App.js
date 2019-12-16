import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";

import Login from "../pages/Login";
import NotFound from "../pages/NotFounds";
import Home from "../pages/Home";

function App() {
  return (
    <BrowserRouter>
      <div>
        <Switch>
          <Route exact path="/" component={Login} />
          <Route exact path="/home" component={Home} />
          <Route component={NotFound} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
