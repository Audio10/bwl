import React from "react";
import "./styles/Item.css";
import "./styles/ItemList.css";

class Item extends React.Component {
  render() {
    return (
      <div className="Item">
        <div className="row">
          <div className="col-4 Item__Circulo">
            <div className="Item__Circulo--forma"> </div>
          </div>
          <div className="col-8 Item__Info">
            <p className="Item__Name"> {this.props.info.sequence} </p>
            <p className="Item__Creado">Creado en: {this.props.info.created } </p>
          </div>
        </div>

        <div className="col-12 Item__Muta">
          <p> { this.props.info.mutation === true ? "Con Mutacion" : "Sin Mutacion"}</p>
        </div>
      </div>
    );
  }
}

class ItemList extends React.Component {
  render() {
    return (
      <div className="row">
        {this.props.items.map(item => {
          return (
            <div className="col-4">
              <Item info={item} />
            </div>
          );
        })}
      </div>
    );
  }
}

export default ItemList;
