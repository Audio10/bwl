import React from "react";
import "./styles/Item.css";
import "./styles/ItemList.css";

class Item extends React.Component {

  constructor() {
    super()
    this.state = {
      name: "",
      created: ""
    }
  }

  render() {
    return (
      <div className="item">
        <div className="item__imagen">
          {this.props.info.mutation ===true ? <div id="circulo" className="item__circulo--conmutacion"> </div> : <div id="circulo" className="item__circulo--sinmutacion"> </div>} 
        </div>
        <div className="item__info">
          <div>
            <p className="item__name"> {this.props.info.humano && this.props.info.humano.name!=="" ? this.props.info.humano.name : "Humano " + this.props.contador} </p>
            <p>Creado en: {(this.props.info.created != null) && this.props.info.created.substring(0, 10).replace("-", "/").replace("-", "/")} </p>
          </div>
        </div>

        <div className="item--mutation">
          <p> {this.props.info.mutation === true ? "Con Mutacion" : "Sin Mutacion"}</p>
        </div>
      </div>
      
    );
    
  }
}

class ItemList extends React.Component {

  render() {
    return (
      <div className="container-fluid itemlist__container">
        <div className="wrapper">
          {this.props.items.map((item, index) => {
            return (
                <Item key={index} info={item} contador={index + 1} />
            );
          })}
        </div>
      </div>
    );
  }
}

export default ItemList;
